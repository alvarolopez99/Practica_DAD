package es.urjc.dad.web.rabbit;

import java.sql.Blob;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.urjc.dad.web.services.MailService;

@Component
public class Receiver {

	@Autowired
	MailService mail;
	
	public void receiveMessage(String message) {
		if(message.contains("|*Image*|")) {
			
			message = message.substring(9);
			System.out.println("Received Reescale Petition<" + message + ">");
			
			//Recibe el id del usuario al que hay que reescalarle la foto
			//Lo lee de la bbdd y modifica su contenido
			  
			
				
				/*
				 * 
				 *
				String nombreFoto = image.getOriginalFilename();
				long tamañoFoto = image.getSize();
				bytes = image.getBytes();
				
				String formatName = nombreFoto.substring(nombreFoto.lastIndexOf(".") + 1);	
				bytes = imageServ.resize(bytes, 200, 200, formatName);
				
				Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
				usuario.setFotoPerfil(imagen);
				
				bphoto = java.util.Base64.getEncoder().encodeToString(bytes);
				
				model.addAttribute("fotoperfil", bphoto);
				
				//(assuming you have a ResultSet named RS)
				Usuario u = userRepo.findById("id");		
				Blob blob = u.getImage();
				

				int blobLength = (int) blob.length();  
				byte[] blobAsBytes = blob.getBytes(1, blobLength);*/


			  
		  }
		  else if(message.contains("|*Mail*|")) {
			  message = message.substring(8);
			  System.out.println("Received Mail Send Petition <" + message + ">");
			  
			  String[] parts = message.split(";;");
			  mail.sendEmail(parts[0], "Certificado Sapiotheca", parts[1]);
			  
			//Recibe el correo electrónico al que es necesario enviar un certificado y el contenido del mismo
		  }
		  
		  //Si no es de esos tipos, se ignora el mensaje...
	    
	  }

}
