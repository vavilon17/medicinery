package com.medicinery.priceimport.job;

import com.medicinery.priceimport.service.PriceImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceImportJob {

    private static final Logger log = LoggerFactory.getLogger(PriceImportJob.class);

    private static final long MILLS_IN_MIN = 1000*60;

    @Autowired
    private PriceImportService priceImportService;

    @Scheduled(fixedDelay = 20000)
    public void runJob() {
        log.info("****** Price import Job - START");
        long start = System.currentTimeMillis();
        priceImportService.runImport();
        log.info("****** Price import Job - FINISH. Duration = {}", (System.currentTimeMillis() - start)/MILLS_IN_MIN);
    }

}
