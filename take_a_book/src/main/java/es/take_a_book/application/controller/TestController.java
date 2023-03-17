package es.take_a_book.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.take_a_book.application.internal_service.Producer;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private Producer producer;
	
	@PostMapping("/send_mail")
	public ResponseEntity<Object> sendMail(){
		producer.send();
		return ResponseEntity.ok().build();
	}
}
