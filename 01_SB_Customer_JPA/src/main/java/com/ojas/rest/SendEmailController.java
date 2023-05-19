package com.ojas.rest;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.Application;

@RestController
public class SendEmailController {
	
	@Autowired
	Application sendingEmailApplication;

	@RequestMapping(value = "/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
	   //sendEmail();
		sendingEmailApplication.sendEmail();
	   return "Email sent successfully";   
	}
}