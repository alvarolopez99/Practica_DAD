package com.example.demo.rabbit;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner{

  private RabbitTemplate rabbitTemplate;
  public final String topicExchangeName = "spring-boot-exchange";

  public Runner(RabbitTemplate rt) {
    rabbitTemplate = rt;
  }
  
  public void mailPetition(String correo, String contenido) {
	  System.out.println("Sending message...");
	  rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", "|*Mail*|"+correo+";;"+contenido);
  }
  
  public void imagePetition(long id, String format) {
	  System.out.println("Sending message...");
	  rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", "|*Image*|"+id+";;"+format);
  }

}
