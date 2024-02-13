package com.example.scheduler.controller;


import com.example.scheduler.repo.SchedulerRepo;
import com.example.scheduler.response.SmsResponse;
import com.example.scheduler.service.SchedulerService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class SchedulerController {


    private static final Logger logger = LoggerFactory.getLogger(SchedulerController.class);

    @Autowired
    private TemplateEngine templateEngine;
    private final SchedulerService schedulerService;


    @GetMapping("/sms")
    @ResponseStatus(HttpStatus.OK)
    public List<SmsResponse> getAllMessages() {
        return schedulerService.getAllTexts();
    }

    @GetMapping("/txt")
    @ResponseStatus(HttpStatus.OK)
    public List<SmsResponse> getTxt(
            @RequestParam("startDate") LocalDate startDate) {
        return schedulerService.getMessages(startDate);
    }

    @GetMapping("/smsreport")
    public String getMessages(Model model) {
        List<SmsResponse> myData = schedulerService.getAllTexts();
        model.addAttribute("myData", myData);
        return "reportTemplate";
    }


    @GetMapping("/txttypereport")
    public void getTxtType(HttpServletResponse response,
            @RequestParam("startDate") LocalDate startDate,
                           Model model) throws IOException, DocumentException {
        List<SmsResponse> myData = schedulerService.getMessages(startDate);


        // Creating Thymeleaf context and add the data
        Context context = new Context();
        context.setVariable("data", myData);

        // Rendering the Thymeleaf template as HTML
        String htmlContent = templateEngine.process("reportTemplate2", context);

        // Generating PDF from HTML using Flying Saucer
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        // Setting response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=report.pdf");

        // Writing PDF content to the response
        response.getOutputStream().write(outputStream.toByteArray());
        response.getOutputStream().flush();
    }


    @GetMapping("/generateReport")
    public void generateReport(HttpServletResponse response) throws IOException, DocumentException {
        // Preparing the data for the report
        List<SmsResponse> smsMessages = schedulerService.getAllTexts();

        // Creating Thymeleaf context and add the data
        Context context = new Context();
        context.setVariable("data", smsMessages);

        // Rendering the Thymeleaf template as HTML
        String htmlContent = templateEngine.process("reportTemplate", context);

        // Generating PDF from HTML using Flying Saucer
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        // Setting response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=report.pdf");

        // Writing PDF content to the response
        response.getOutputStream().write(outputStream.toByteArray());
        response.getOutputStream().flush();
    }

}
