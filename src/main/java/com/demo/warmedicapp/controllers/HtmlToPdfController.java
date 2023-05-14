//package com.demo.warmedicapp.controllers;
//
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.pdf.PdfReader;
//import jakarta.servlet.http.HttpServletResponse;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//@RestController
//public class HtmlToPdfController {
//
//    @PostMapping("/convert")
//    public void convertHtmlToPdf(@RequestBody String htmlContent, HttpServletResponse response) throws IOException {
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
//            ITextRenderer renderer = new ITextRenderer();
//            ITextUserAgent userAgent = new ITextUserAgent(renderer.getOutputDevice());
//            renderer.getSharedContext().setUserAgentCallback(userAgent);
//
//            renderer.setDocumentFromString(htmlContent);
//            renderer.layout();
//            try {
//                renderer.createPDF(outputStream);
//            } catch (DocumentException e) {
//                throw new RuntimeException(e);
//            }
//
//            // Set response headers
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=\"output.pdf\"");
//
//            // Copy PDF content to response
//            InputStream inputStream = StreamUtils.copyToByteArray(outputStream.toByteArray());
//            StreamUtils.copy(inputStream, response.getOutputStream());
//        }
//    }
//}