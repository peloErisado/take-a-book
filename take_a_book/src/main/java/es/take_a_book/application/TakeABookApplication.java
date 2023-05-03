package es.take_a_book.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@SpringBootApplication
@EnableTransactionManagement
public class TakeABookApplication {

		private static final Log LOG = LogFactory.getLog(TakeABookApplication.class);
	
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
	
	@Bean
	public CacheManager cacheManager() {
		LOG.info("Activando la caché...");
		return new ConcurrentMapCacheManager("authors", "books");
	}
	
	
	
	
}
