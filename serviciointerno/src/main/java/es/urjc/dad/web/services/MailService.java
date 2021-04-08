package es.urjc.dad.web.services;

import org.springframework.stereotype.Component;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Component
public class MailService {
	
	public void sendEmail(String to, String subject, String content) {
		
        // Email de la web en gmail 
        String from = "urjc.fower@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        //Setup
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Autenticación de la sesion
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "fower4fower4");

            }

        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println("Enviado....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
	}

}
