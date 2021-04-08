package es.urjc.dad.web;

import java.net.Socket;
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

import rabbit.Receiver;


@SpringBootApplication
public class ServiciointernoApplication {

	static final String topicExchangeName = "spring-boot-exchange";

	  static final String queueName = "spring-boot";

	  @Bean
	  Queue queue() {
	    return new Queue(queueName, false);
	  }

	  @Bean
	  TopicExchange exchange() {
	    return new TopicExchange(topicExchangeName);
	  }

	  @Bean
	  Binding binding(Queue queue, TopicExchange exchange) {
	    return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	  }

	  @Bean
	  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	      MessageListenerAdapter listenerAdapter) {
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(queueName);
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }

	  @Bean
	  MessageListenerAdapter listenerAdapter(Receiver receiver) {
	    return new MessageListenerAdapter(receiver, "receiveMessage");
	  }

	  public static void main(String[] args) throws InterruptedException {
	    SpringApplication.run(ServiciointernoApplication.class, args).close();
	  }
	  
	/*public static void main(String[] args) {
		SpringApplication.run(ServiciointernoApplication.class, args);

		final Logger LOGGER=LoggerFactory.getLogger(ServiciointernoApplication.class);


		try {
			
			ServerSocket serverSocket = new ServerSocket(9999);
			LOGGER.info("*A LA ESPERA*");
			Socket socket = serverSocket.accept();
			LOGGER.info("*SE HAN CONECTADO*");
			InputStreamReader InStrReaderStn = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderStn);

			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
			
			
			while(true) {
				LOGGER.info("************");
				//String line = BRSocketIn.readLine();
				//PWSocketOut.println(line);
				PWSocketOut.println("HelloClient");
				PWSocketOut.flush();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		


	
	}*/

}
