package com.medicinery.priceimport.service.processor.tmp;

import com.medicinery.priceimport.data.jaxb.werru.Drug;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PriceItemProcessor implements ItemProcessor<Drug, Drug> {

    private final static Logger log = LoggerFactory.getLogger(PriceItemProcessor.class);

    @Override
    public Drug process(final Drug drug) throws Exception {
        System.out.println("Name: " + drug.getName() + ", form: " + drug.getForm() + ", url: " + drug.getUrl()
                + ", vendor: " + drug.getVendor() + ", price: " + drug.getPrice());
        return drug;
    }
}
