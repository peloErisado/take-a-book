package es.take_a_book.internal_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@RabbitListener(queues = "mail_queue", ackMode = "AUTO")
	public void listen(String message) {
		mailSenderService.sendMail("dieguparalauni@gmail.com", "Test", "Test e-mail");
		System.out.print("Message received: "+message);
	}
}
