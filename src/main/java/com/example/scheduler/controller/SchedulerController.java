package com.example.scheduler.controller;


import com.example.scheduler.response.SmsResponse;
import com.example.scheduler.service.SchedulerService;
import com.lowagie.text.DocumentException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return schedulerService.getMessages(startDate, endDate);
    }

    @GetMapping("/txttypereport")
    public void getTxtType(HttpServletResponse response,
            @RequestParam("startDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) throws IOException, DocumentException {


        List<SmsResponse> myData = schedulerService.getMessages(startDate, endDate);

        // Creating Thymeleaf context and add the data
        Context context = new Context();
        context.setVariable("data", myData);
        context.setVariable("endDate", endDate);
        context.setVariable("startDate", startDate);

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

}
