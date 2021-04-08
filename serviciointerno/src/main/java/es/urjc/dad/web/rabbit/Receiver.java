package es.urjc.dad.web.rabbit;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);	//Sincronizacion

	  public void receiveMessage(String message) {
	    System.out.println("Received <" + message + ">");
	    //latch.countDown();
	  }

	  public CountDownLatch getLatch() {
	    return latch;
	  }
}
