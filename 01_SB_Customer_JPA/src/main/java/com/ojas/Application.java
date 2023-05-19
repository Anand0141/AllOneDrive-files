package com.ojas;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.ojas.email.EmailUtilsEx;
import com.ojas.entity.CustomerEntity;
import com.ojas.repo.CustomerRepo;

@SpringBootApplication
public class Application {
//What is SMTP Server?
	/*
	 * The acronym of SMTP is the Simple Mail Transfer Protocol. Whenever we send a
	 * mail to another person’s email id, then there is some protocol through which
	 * our email goes through before delivering to the mentioned email id.
	 * 
	 * That protocol is the SMTP server which acts as an intermediate between your
	 * email id and the person email id whom you send the email. You can consider an
	 * SMTP as real-life Postman, who takes the letter from one place and delivered
	 * to the address which is mentioned in that letter.
	 */
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		CustomerRepo custoDao = ctx.getBean(CustomerRepo.class);
		CustomerEntity entity=new CustomerEntity();
		entity.setCname("shiva");
		entity.setCadd("hyd");
		CustomerEntity cust = custoDao.save(entity);
		String msg;
		if(cust!=null)
		{
			msg="Customer Registration Successfully";
			System.out.println(cust.getCname()+"\t"+cust.getCadd());
		}
		else
		{
			msg="Customer Registration is Fail";
		}
	}

	@Autowired
	private  JavaMailSender javaMailSender;

	public 	void sendEmail() {

	    SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setTo("yannamsiva@gmail.com");

	    msg.setSubject("Testing from Spring Boot");
	    msg.setText("Registre Successfully");

	    javaMailSender.send(msg);

	}

	 public void sendEmailWithAttachment() throws MessagingException, IOException {

	    MimeMessage msg = javaMailSender.createMimeMessage();

	    // true = multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(msg, true);

	    helper.setTo("yannamsiva@gmail.com");

	    helper.setSubject("Testing from Spring Boot");

	    // default = text/plain
	    //helper.setText("Check attachment for image!");

	    // true = text/html
	    helper.setText("<h1>Check attachment for image!</h1>", true);

		// hard coded a file path
	  //  FileSystemResource file = new FileSystemResource(new File("C:/Users\\1302143\\Desktop\\ssl4.png"));

	    //helper.addAttachment("ssl4.png", file);

	    javaMailSender.send(msg);

	}	

	
	
	
	
}
