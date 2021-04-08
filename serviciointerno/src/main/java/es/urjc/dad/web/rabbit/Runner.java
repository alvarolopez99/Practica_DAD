package es.urjc.dad.web.rabbit;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.urjc.dad.web.ServiciointernoApplication;

@Component
public class Runner implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;
  private final Receiver receiver;

  public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Sending message...");
    rabbitTemplate.convertAndSend(ServiciointernoApplication.topicExchangeName, "foo.bar.baz", "|*Mail*|"+"Hello from RabbitMQ!");
    
    System.out.println("Sending message...");
    rabbitTemplate.convertAndSend(ServiciointernoApplication.topicExchangeName, "foo.bar.baz", "|*Image*|"+"Hello from RabbitMQ!");
  }

}
