package com.example.services;

import org.springframework.stereotype.Component;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Component
public class MailService {
	
	public void sendEmail() {
		String to = "pbayonag@hotmail.com";
	    String from = "00pabloba@gmail.com";
	    String host = "localhost";//or IP address  
	  
	    //Get the session object  
	    Properties properties = System.getProperties();  
	    properties.setProperty("mail.smtp.host", host);  
	    Session session = Session.getDefaultInstance(properties);  
	  
	    //compose the message  
	    try{  
	       MimeMessage message = new MimeMessage(session);  
	       message.setFrom(new InternetAddress(from));  
	       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	       message.setSubject("Ping");  
	       message.setText("Esto es una prueba de envío de mensaje");  
	  
	       // Send message  
	       Transport.send(message);  
	       System.out.println("message sent successfully....");  
	  
	    }catch (MessagingException mex) {mex.printStackTrace();}  
		
	}

}
