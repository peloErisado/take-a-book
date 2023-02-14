package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import repository.BookRepository;

@SpringBootTest
class TakeABookApplicationTests {
	
	@Autowired BookRepository books;
	
	@Test
	void contextLoads() {
		
	}

}
