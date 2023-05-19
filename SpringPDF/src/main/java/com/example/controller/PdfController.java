package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Data;
import com.example.service.PdfService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private PdfService pdfService;

	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping("/send")
	public ResponseEntity<?> sendPdf(@RequestBody List<Data> data) throws MessagingException, IOException, DocumentException {
		//try {
			// generate the PDF as a byte array
			byte[] bytes = pdfService.generatePdf(data);

			// create the email message with the PDF as an attachment
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo("mamidalaharish1997@gmail.com");
			helper.setSubject("My Data");
			helper.setText("Please find attached the PDF with my data.");
			helper.addAttachment("My Data.pdf", new ByteArrayResource(bytes));
			// send the email message
			javaMailSender.send(message);

			return ResponseEntity.ok().build();
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
	}
}
