package com.medicinery.priceimport.service.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class PriceImportJobListener implements JobExecutionListener {

    private long startTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("BEFORE JOB");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("AFTER JOB. Time=" + (System.currentTimeMillis() - startTime));
    }
}
