package com.medicinery.priceimport.conf;

import com.medicinery.priceimport.data.jaxb.werru.Drug;
import com.medicinery.priceimport.service.batch.PriceImportJobListener;
import com.medicinery.priceimport.service.batch.PriceItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableBatchProcessing
@ComponentScan(basePackages = "com.medicinery.priceimport")
@PropertySource({"classpath:/import.properties"})
public class AppConf extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("jdbc.url"),
                env.getProperty("jdbc.username"), env.getProperty("jdbc.password"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        PlatformTransactionManager transactionManager = getTransactionManager();
        MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean(transactionManager);
        mapJobRepositoryFactoryBean.setTransactionManager(transactionManager);
        return mapJobRepositoryFactoryBean.getObject();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository);
        return simpleJobLauncher;
    }

    /**
     * batch part
     */
    /*@Bean
    public FlatFileItemReader<Drug> reader() {
        FlatFileItemReader<Drug> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(env.getProperty("batch.path.wer.ru")));
        reader.setLineMapper(new DefaultLineMapper<Drug>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "firstName", "lastName" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Drug>() {{
                setTargetType(Drug.class);
            }});
        }});
        return reader;
    }*/

    @Bean
    public StaxEventItemReader<Drug> reader() {
       StaxEventItemReader<Drug> reader = new StaxEventItemReader<>();
       System.out.println("Path to the resource: " + env.getProperty("batch.path.wer.ru"));
       reader.setResource(new FileSystemResource(env.getProperty("batch.path.wer.ru")));
       reader.setFragmentRootElementName("drug");
       reader.setUnmarshaller(unmarshaller());
       return reader;
    }

    @Bean
    public ItemWriter<Drug> writer() {
        return (List<? extends Drug> items) -> {
            System.out.println("Start WrITER logic...");
            for (Drug i : items) {
                System.out.println("*Drug, url: " + i.getUrl());
            }
        };
    }


    @Bean
    public PriceItemProcessor processor() {
        return new PriceItemProcessor();
    }

    private Unmarshaller unmarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Drug.class);
        return marshaller;
    }

    @Bean
    public Job importPricesJob(PriceImportJobListener listener) {
        return jobBuilderFactory.get("pricesImportJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Drug, Drug> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
