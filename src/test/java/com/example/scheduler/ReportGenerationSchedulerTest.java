//package com.example.scheduler;
//
//
//import com.example.scheduler.scheduler.ReportGenerationScheduler;
//import com.example.scheduler.service.SchedulerService;
//import com.lowagie.text.DocumentException;
//import jakarta.servlet.http.HttpServletResponse;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.io.IOException;
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.mock;
//
//@SpringBootTest
//@ContextConfiguration(classes = {ReportGenerationScheduler.class})
//public class ReportGenerationSchedulerTest {
//
//    // Create mock objects for HttpServletResponse and Model
//    HttpServletResponse mockedResponse = mock(HttpServletResponse.class);
//    Model mockedModel = mock(Model.class);
//    @Autowired
//    private ReportGenerationScheduler schedulerTester;
//
//    @MockBean
//    private SchedulerService schedulerService;
//
//    LocalDate expectedStartDate = LocalDate.of(2024, 1, 1);
//    LocalDate expectedEndDate = LocalDate.of(2024, 1, 31);
//
//    @Test
//    public void testGeneratedMonthlyReport() throws DocumentException, IOException {
//        schedulerTester.generateMonthlyReport();
//
//        schedulerService.generateReport(expectedStartDate, expectedEndDate);
//
//        Mockito.verify(schedulerService, Mockito.times(1)).generateReport(eq(expectedStartDate), eq(expectedEndDate));
//
//        // Generate the report content
//        byte[] reportContent = schedulerService.generateReport(LocalDate.now(), LocalDate.now());
//
//        // Assert that the report content is not null and has some content
//        assertNotNull(reportContent);
//        assertTrue(reportContent.length > 0);
//    }
//}
