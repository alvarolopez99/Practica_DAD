package es.urjc.dad.web;

import java.net.Socket;

import javax.net.ServerSocketFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.urjc.dad.web.rabbit.Receiver;


@SpringBootApplication
public class ServiciointernoApplication {

	  public static final String topicExchangeName = "spring-boot-exchange";
		
		
	  static final String queueName = "spring-boot";

	  @Bean
	  Queue queue() {	//Crea una cola AMQ
	    return new Queue(queueName, false);
	  }

	  @Bean
	  TopicExchange exchange() {	
	    return new TopicExchange(topicExchangeName);
	  }

	  @Bean
	  Binding binding(Queue queue, TopicExchange exchange) {	//Enlaza los anteriores
	    return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");	//Mensajes con clave foor.bar+ se dirigen a la cola
	  }

	  @Bean
	  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,		//Sets para la cola de mensajes
	      MessageListenerAdapter listenerAdapter) {
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(queueName);
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }

	  @Bean
	  MessageListenerAdapter listenerAdapter(Receiver receiver) {	//Delega la escucha de mensajes al receiver y al metodo receiveMessage
	    return new MessageListenerAdapter(receiver, "receiveMessage");
	  }

	
	  
	public static void main(String[] args) {
		SpringApplication.run(ServiciointernoApplication.class, args);
		
		int puerto = 9999;
		ServerSocketFactory ssf = ServerSocketFactory.getDefault();

		
		try {
			ServerSocket serverSocket = ssf.createServerSocket(puerto);
			//ServerSocket serverSocket = new ServerSocket(puerto);
			
			while(true) {
				Socket socket = serverSocket.accept();		// Esperar a que llegue una petición de un cliente
				Thread t = new Thread(new ProcesadorSockets(socket));
				t.start();									// Ejecutarla en un hilo y seguir atendiendo nuevas peticiones
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		


	
	}	

}
