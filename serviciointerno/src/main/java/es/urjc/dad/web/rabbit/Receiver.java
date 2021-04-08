package es.urjc.dad.web.rabbit;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

import es.urjc.dad.web.Model.Usuario;
import es.urjc.dad.web.Repository.UsuarioRepository;
import es.urjc.dad.web.services.ImageService;
import es.urjc.dad.web.services.MailService;


@Component
public class Receiver {

	@Autowired
	MailService mail;
	
	@Autowired
	UsuarioRepository userRepo;
	
	@Autowired
	ImageService imageServ;
	
	public void receiveMessage(String message) throws SQLException, IOException {
		if(message.contains("|*Image*|")) {
			
			message = message.substring(9);
			System.out.println("Received Reescale Petition<" + message + ">");
			
			//Recibe el id del usuario al que hay que reescalarle la foto
			//Lo lee de la bbdd y modifica su contenido
			  
			
			String[] parts = message.split(";;");	//id usuario + formato imagen
			
			Optional<Usuario> u = userRepo.findById(Long.parseLong(parts[0]));
			if(u.isPresent()) {
				
				Usuario user = u.get();
				Blob imagen = user.getFotoPerfil();
				
				int blobLength = (int) imagen.length();
				byte[] blobAsBytes = imagen.getBytes(1, blobLength);
				
				blobAsBytes = imageServ.resize(blobAsBytes, 200, 200, parts[1]);
				
				imagen = new javax.sql.rowset.serial.SerialBlob(blobAsBytes);
				user.setFotoPerfil(imagen);
				
				userRepo.save(user);
				
				
			}
			
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
			  
			  String[] parts = message.split(";;");	//Correo + contenido
			  mail.sendEmail(parts[0], "Certificado Sapiotheca", parts[1]);
			  
			//Recibe el correo electrónico al que es necesario enviar un certificado y el contenido del mismo
		  }
		  
		  //Si no es de esos tipos, se ignora el mensaje...
	    
	  }

}
