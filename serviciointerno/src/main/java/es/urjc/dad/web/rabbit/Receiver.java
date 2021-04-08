package es.urjc.dad.web.rabbit;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	public void receiveMessage(String message) {
		  if(message.contains("|*Image*|")) {
			  message = message.substring(9);
			  System.out.println("Received Reescale Petition<" + message + ">");
		  }
		  else if(message.contains("|*Mail*|")) {
			  message = message.substring(8);
			  System.out.println("Received Mail Send Petition <" + message + ">");
		  }
		  
		  //Si no es de esos tipos, se ignora el mensaje...
	    
	  }

}
