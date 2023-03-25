package es.take_a_book.application;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TakeABookApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeABookApplication.class, args);
	}
	
	@Bean
	Queue testQueue() {
		return new Queue("test_queue", false);
	}
	
	@Bean
	Queue mailQueue() {
		return new Queue("mail_queue", false);
	}

}
