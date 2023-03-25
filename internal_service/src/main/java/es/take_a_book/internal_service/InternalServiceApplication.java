package es.take_a_book.internal_service;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InternalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalServiceApplication.class, args);
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
