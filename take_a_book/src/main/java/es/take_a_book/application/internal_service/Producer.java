package es.take_a_book.application.internal_service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send() {
		String message = "This is a message sent by the application.";
		rabbitTemplate.convertAndSend("mail_queue", message);
		
		System.out.print("Sending message: "+message);
	}
}
