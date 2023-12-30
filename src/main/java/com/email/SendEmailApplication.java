package com.email;

import com.email.model.EmailRequest;
import com.email.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendEmailApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApplication.class, args);
	}

	@Autowired
	private EmailServiceImpl emailService;

	@Override
	public void run(String... args) throws Exception {
		emailService.sendHtmlEmail(getEmailHtmlContent());
		System.out.println("Email sent successfully!");
	}


	private EmailRequest getEmailContent(){
		EmailRequest emailRequest =new EmailRequest();
		emailRequest.setTo("springbootapp.email.from@gmail.com");
        emailRequest.setSubject("AppSpringboot");
		String emailContent  = "<h2>Wel come</h2>";
		emailRequest.setBody(emailContent);
		return emailRequest;
	}

	private EmailRequest getEmailHtmlContent(){
		EmailRequest emailRequest =new EmailRequest();
		emailRequest.setTo("springbootapp.email.from@gmail.com");
		emailRequest.setSubject("App Springboot HtmlContent");
		String emailContent  = "<h2>FileAttached<h2>";
		emailRequest.setBody(deviceInfo);
		return emailRequest;
	}

	private EmailRequest getEmailAttachedContent(){
		EmailRequest emailRequest =new EmailRequest();
		emailRequest.setTo("springbootapp.email.from@gmail.com");
		emailRequest.setSubject("App Springboot Attached");
		String emailContent  = "FileAttached";
		emailRequest.setBody(emailContent);
		emailRequest.setFile("test.csv");
		return emailRequest;
	}

   private static final String deviceInfo = "<!DOCTYPE html>\n" +
		   "<html>\n" +
		   "<body>\n" +
		   "\n" +
		   "<h2>Get the size of the current screen/window</h2>\n" +
		   "<p>The example displays the browser window's height and width: (NOT including toolbars/scrollbars)\n" +
		   "\n" +
		   "<p id=\"demo\"></p>\n" +
		   "\n" +
		   "<script>\n" +
		   "var w = window.innerWidth;\n" +
		   "var h = window.innerHeight;\n" +
		   "\n" +
		   "var x = document.getElementById(\"demo\");\n" +
		   "alert(\"Hello\");\n" +
		   "x.innerHTML = \"<h3>Browser width: \" + w + \", height: \" + h + \".</h3>\";\n" +
		   "</script>\n" +
		   "\n" +
		   "</body>\n" +
		   "</html>\n";
}
