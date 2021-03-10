package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	private JavaMailSender emailSender;

	public MailService(JavaMailSender emailSender) {
	
		this.emailSender = emailSender;
	}
	
	public void sendSimpleMessage(String name, String subject , String text) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(name);
		message.setSubject(subject);
		message.setText(text);
		
		emailSender.send(message);
		
	
		
	}

	
	

}
