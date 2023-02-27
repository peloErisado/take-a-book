package es.take_a_book.application.model;

import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billNumber;
	
	private float totalPrice = 0;
	private String payment = "";
	
	@ManyToOne
	private Users user;
	@OneToOne
	private Book book;
	
	public Purchase() {};
	
	//Constructor
	public Purchase(/*Users user,*/Book book, String payment) {
		/*for(int i = 0; i<books.size(); i++) {
			totalPrice += books.get(i).getPrice();
		}*/
		//this.user = user;
		totalPrice = book.getPrice();
		this.book = book;
		this.payment = payment;
	}
	
	//Getters
	public long getBillNumber() {
		return billNumber;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public String getPayment() {
		return payment;
	}
	public Users getUser() {
		return user;
	}
	public Book getBook(){
		return book;
	}
	//Setters
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
}
