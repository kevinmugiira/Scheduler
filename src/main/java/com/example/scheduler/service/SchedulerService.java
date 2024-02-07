package com.example.scheduler.service;


import com.example.scheduler.controller.SchedulerController;
import com.example.scheduler.model.ChannelsModel;
import com.example.scheduler.model.SmsModel;
import com.example.scheduler.repo.ChannelsRepo;
import com.example.scheduler.repo.SchedulerRepo;
import com.example.scheduler.response.SmsResponse;
import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    @Autowired
    private TemplateEngine templateEngine;
    private final SchedulerRepo schedulerRepo;
    private final ChannelsRepo channelsRepo;
    private static final Logger logger = LoggerFactory.getLogger(SchedulerController.class);


    public List<SmsResponse> getMessages(LocalDate endDate) {

        // Calculate the endDate (one month prior to startDate)
        LocalDate startDate = endDate.minusMonths(1);
        List<Object[]> messages = schedulerRepo.getTxnTypeCount(startDate, endDate);
        System.out.println(messages);
        logger.info("Size of myData: {}", messages.size());

        for (Object[] responses : messages) {
            String txnType = (String) responses[0];
            Long smsCount = (Long) responses[1]; // Change the cast to Long
            logger.info("TXN_TYPE: {}, SMS_COUNT: {}", txnType, smsCount);
        }

        for (Object[] responses : messages) {
            logger.info("responses: {}", responses, responses);
        }

        return messages.stream()
                .map(this::mapToObject)
                .collect(Collectors.toList());
    }

    public List<SmsResponse> getAllTexts() {
        List<SmsModel> messages = schedulerRepo.findAll();
        return messages.stream()
                .map(this::mapToSmsResponse)
                .collect(Collectors.toList());
    }

    private SmsResponse mapToObject(Object[] objArray) {
        // Assuming objArray[0] is TXN_TYPE and objArray[1] is SMS_COUNT
        SmsResponse smsResponse = new SmsResponse();
        smsResponse.setTXN_TYPE((String) objArray[0]);
        smsResponse.setSMS_COUNT((Long) objArray[1]);

        return smsResponse;
    }

    private SmsResponse mapToSmsResponse(SmsModel smsModel) {
        return SmsResponse.builder()
                .id(smsModel.getId())
                .PHONE_NUMBER(smsModel.getPHONENUMBER())
                .MESSAGE(smsModel.getMESSAGE())
                .REFERENCE(smsModel.getREFERENCE())
                .PG_STATUS_CODE(smsModel.getPG_STATUS_CODE())
                .PG_STATUS_DESC(smsModel.getPG_STATUS_DESC())
                .CREATED_ON(smsModel.getCREATED_ON())
                .RE_POSTED(smsModel.getRE_POSTED())
                .TRIALS(smsModel.getTRIALS())
                .TXN_TYPE(smsModel.getTXN_TYPE())
                .build();
    }


//    public byte[] generateReport(@RequestParam("startDate") LocalDate startDate,
//                                 @RequestParam("endDate") LocalDate endDate) throws IOException, DocumentException {
////        List<SmsResponse> myData = schedulerService.getMessages(startDate, endDate);
//        List<Object[]> myData = schedulerRepo.getTxnTypeCount(startDate, endDate);
//
//        // Creating Thymeleaf context and adding the data
//        Context context = new Context();
//        context.setVariable("data", myData);
//
//        // Rendering the Thymeleaf template as HTML
//        String htmlContent = templateEngine.process("reportTemplate2", context);
//
//        // Generating PDF from HTML using Flying Saucer
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.setDocumentFromString(htmlContent);
//        renderer.layout();
//        renderer.createPDF(outputStream);
//
//
//        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
//        // Setting response headers
//        assert response != null;
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "inline; filename=report.pdf");
//
//        // Writing PDF content to the response
//        response.getOutputStream().write(outputStream.toByteArray());
//        response.getOutputStream().flush();
//
//        return outputStream.toByteArray();
//    }

    public void generateReport(LocalDate endDate) throws DocumentException, IOException  {

        // Calculate the endDate (one month prior to startDate)
        LocalDate startDate = endDate.minusMonths(1);
        System.out.println(startDate);

        List<Object[]> myData = schedulerRepo.getTxnTypeCount(startDate, endDate);
        List<ChannelsModel> myChannels = channelsRepo.findAll();
        Context context = new Context();
        context.setVariable("data", myData);
        if (myChannels != null) {
            context.setVariable("data2", myChannels);
        } else {
            context.setVariable("data2", Collections.emptyList());
        }

        // logging the data
        for (ChannelsModel da : myChannels) {
            StringBuilder strs = new StringBuilder();
            strs.append("[");
            strs.append(da.getCHANNEL());
            strs.append("]");
            System.out.println(strs.toString());
        }

        // logging the data
        for (Object[] row : myData) {
            StringBuilder rowString = new StringBuilder();
            rowString.append("[");
            for (int i = 0; i < row.length; i++) {
                rowString.append(row[i]);
                if (i < row.length - 1) {
                    rowString.append(", ");
                }
            }
            rowString.append("]");
            System.out.println(rowString.toString());
        }

        String htmlContent = templateEngine.process("reportTemplate", context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        try {
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);

            // Define the file path and name where you want to save the PDF
            String filePath = "/home/kevin-m/report/report.pdf";

            // Write the PDF content to the file system
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                fileOutputStream.write(outputStream.toByteArray());
            }
        } catch (IOException | DocumentException e) {
            // Handle exceptions
            e.printStackTrace(); // Logging or throw custom exception
        } finally {
            // Close the renderer explicitly
            renderer.finishPDF(); // Close the PDF document
            renderer = null; // Release the reference
        }
    }

}
