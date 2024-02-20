package com.example.scheduler.configurations;


import com.example.scheduler.service.SchedulerService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.LocalDate;

@Configuration
public class SchedulerConfig {

    @Autowired
    private SchedulerService schedulerService;

    @Value("${report.endDate}")
    private String endDateStr;

    @Bean
    public LocalDate endDate() {
        return LocalDate.parse(endDateStr);
    }


    @Bean
    @ConditionalOnProperty(name = "myapp.scheduler.enabled", havingValue = "true", matchIfMissing = true)
    public Runnable reportGenerationTask(SchedulerService schedulerService, LocalDate endDate) {
        return () -> {
            if (endDate != null) {
                try {
                    schedulerService.generateReport(endDate);
                } catch (DocumentException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Report generation task executed!");
            } else {
                System.out.println("End date is not set.");
            }
        };
    }

    @Scheduled(cron = "0 * * * * ?")
    public void executeReportGenerationTask() {
        reportGenerationTask(schedulerService, endDate()).run();
    }
}
