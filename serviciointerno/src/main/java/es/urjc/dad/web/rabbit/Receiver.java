package es.urjc.dad.web.rabbit;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Receiver {

	public void receiveMessage(String message) {
		  if(message.contains("|*Image*|")) {
			  message = message.substring(9);
			  System.out.println("Received Reescale Petition<" + message + ">");
			  //Recibe el id del usuario al que hay que reescalarle la foto
			  //Lo lee de la bbdd y modifica su contenido

			  
		  }
		  else if(message.contains("|*Mail*|")) {
			  message = message.substring(8);
			  System.out.println("Received Mail Send Petition <" + message + ">");
			//Recibe el correo electrónico al que es necesario enviar un certificado
		  }
		  
		  //Si no es de esos tipos, se ignora el mensaje...
	    
	  }

}
