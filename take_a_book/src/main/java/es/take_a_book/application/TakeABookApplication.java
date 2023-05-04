package es.take_a_book.application;

import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
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
	
	@Bean
	public Config config() {
		Config config = new Config();
		JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		joinConfig.getMulticastConfig().setEnabled(false);
		joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Arrays.asList("take-a-book-web-1","take-a-book-web-2"));
		
		return config;
	}
}
