package es.take_a_book.internal_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	String serviceMail = "takeabook.mail@gmail.com";
	
	public void sendMail(String receiver, String subjet, String body) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(serviceMail);
		mail.setTo(receiver);
		mail.setSubject(subjet);
		mail.setText(body);
		javaMailSender.send(mail);
		
		System.out.println("Sending mail to "+receiver);
	}
}
