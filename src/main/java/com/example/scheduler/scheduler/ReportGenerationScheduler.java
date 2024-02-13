package com.example.scheduler.scheduler;


import com.example.scheduler.service.SchedulerService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Component
@ConditionalOnProperty(name = "myapp.scheduler.enabled", havingValue = "true", matchIfMissing = true)
public class ReportGenerationScheduler {

    @Autowired
    private SchedulerService schedulerService;

//    private LocalDate startDate;
    private LocalDate endDate;

    // Method to set the dates
    public void setDates(LocalDate endDate) {
//        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Scheduled(cron = "0 * * * * ?")
    public void generateMonthlyReport() throws DocumentException, IOException {

        if (endDate != null) {
            schedulerService.generateReport(endDate);
            System.out.println("Report generation task executed!");
        } else {
            System.out.println("end date is not set.");
        }
    }
}
