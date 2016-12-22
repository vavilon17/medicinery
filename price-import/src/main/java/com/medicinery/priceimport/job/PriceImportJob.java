package com.medicinery.priceimport.job;

import com.medicinery.priceimport.service.PriceImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceImportJob {

    private static final Logger log = LoggerFactory.getLogger(PriceImportJob.class);

    private static final long MILLS_IN_MIN = 1000*60;

    @Autowired
    private PriceImportService priceImportService;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(fixedDelay = 20000)
    public void runJob() {

        System.out.println("Start scheduled task");
        try {
            jobLauncher.run(job, new JobParameters());
        } catch (JobExecutionAlreadyRunningException | JobRestartException
                | JobInstanceAlreadyCompleteException| JobParametersInvalidException e) {
            System.out.println(e);
        }
        /*System.out.println("asfasdfasdfasdfaasdfasdfasdfasdfasdf ************************** ");
        log.info("****** Price import Job - START");
        long start = System.currentTimeMillis();
        priceImportService.runImport();
        log.info("****** Price import Job - FINISH. Duration = {}", (System.currentTimeMillis() - start)/MILLS_IN_MIN);*/
    }

}
