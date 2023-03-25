package es.take_a_book.application.internal_service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.Purchase;
import es.take_a_book.application.model.Users;

@Component
public class Producer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void send() {
		String message = "This is a message sent by the application.";
		rabbitTemplate.convertAndSend("mail_queue", message);
		
		System.out.print("Sending message: "+message);
	}
	
	public void sendSignUpMessage(Users u) {
		String reciever = u.getMail();
		String subject = "¡Bienvenido a Take a Book!";
		String body = "¡Hola! "+ u.getUsername() + "\n Tu cuenta en Take a Book ha sido creada correctamente. ¡Gracias por usar nuestros servicios!";
		
		String message = reciever + "|" + subject + "|" + body;
		rabbitTemplate.convertAndSend("mail_queue", message);
		System.out.print("Sending message: "+message);
	}
	
	public void sendPurchaseMessage(Users u, Purchase p) {
		String reciever = u.getMail();
		String subject = "Resumen de tu compra";
		
		String books ="";
		for(int i =0; i<p.getBooks().size(); i++) {
			books += p.getBooks().get(i).getTitle() +", ";
		}
		
		String body = "¡Hola! "+ u.getUsername() + "\n Aquí tienes un resumen de tu compra:" 
				+ "\n Número de pedido: "+ p.getBillNumber() 
				+ "\n Resumen del pedido: " + books 
				+ "\n Precio total de tu compra: " + p.getTotalPrice()
				+ "\n Métodod de pago elegido:  " + p.getPayment() 
				+ "\n ¡Gracias por usar nuestros servicios!";
		
		String message = reciever + "|" + subject + "|" + body;
		rabbitTemplate.convertAndSend("mail_queue", message);
		System.out.print("Sending message: "+message);
	}
	
	public void sendLoanMessage(Users u, Loan l) {
		String reciever = u.getMail();
		String subject = "Resumen de tu pedido";
		
		String body = "¡Hola! "+ u.getUsername() + "\n Aquí tienes un resumen de tu pedido:" 
				+ "\n Número de pedido: "+ l.getNumResguardo() 
				+ "\n Resumen del pedido: " + l.getBook().getTitle() 
				+ "\n Fecha de inicio del préstamo: " + l.getFechaInicio()
				+ "\n Recuerda que el préstamo finaliza el día:  " + l.getFechaFin()
				+ "\n ¡Gracias por usar nuestros servicios!";
		
		String message = reciever + "|" + subject + "|" + body;
		rabbitTemplate.convertAndSend("mail_queue", message);
		System.out.print("Sending message: "+message);
	}
	
	
}
