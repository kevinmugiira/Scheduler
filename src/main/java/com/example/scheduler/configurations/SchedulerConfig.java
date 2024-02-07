package com.example.scheduler.configurations;


import com.example.scheduler.scheduler.ReportGenerationScheduler;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SchedulerConfig {

    @Autowired
    private ReportGenerationScheduler scheduler;

//    @Value("${report.startDate}")
//    private String startDateStr;

    @Value("${report.endDate}")
    private String endDateStr;

    @PostConstruct
    public void init() {
        // Parse the start and end dates from strings
//        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Set the dates in the scheduler
        scheduler.setDates(endDate);
    }
}
