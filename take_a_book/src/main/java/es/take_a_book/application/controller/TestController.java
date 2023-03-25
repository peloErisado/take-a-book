package es.take_a_book.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.take_a_book.application.internal_service.Producer;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private Producer producer;
	
	@PostMapping("/send_test")
	public ResponseEntity<Object> sendMail(){
		producer.send();
		return ResponseEntity.ok().build();
	}
	
	
	/*@PostMapping("/send_mail")
	public ResponseEntity<Object> sendMail(@RequestParam String mail, @RequestParam String subject, @RequestBody String body){
		producer.send(mail, subject, body);
		return ResponseEntity.ok().build();
	}*/
}
