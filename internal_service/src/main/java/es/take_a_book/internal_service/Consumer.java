package es.take_a_book.internal_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@RabbitListener(queues = "test_queue", ackMode = "AUTO")
	public void listenTestQueue(String message) {
		mailSenderService.sendMail("dieguparalauni@gmail.com", "Test", "Test e-mail");
		System.out.println("Message received: "+message);
	}
	
	@RabbitListener(queues = "mail_queue", ackMode = "AUTO")
	public void listenMailQueue(String message) {
		String decodedMessage[] = message.split("§");
		mailSenderService.sendMail(decodedMessage[0], decodedMessage[1], decodedMessage[2]);
		System.out.println("Message received: "+message);
	}
}
