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
	private String payment;
	
	@ManyToOne
	private Users user;
	@OneToMany 
	private List<Book> books;
	
	//Constructor
	public Purchase(Users user, List <Book> books, String payment) {
		for(int i = 0; i<books.size(); i++) {
			totalPrice += books.get(i).getPrice();
		}
		this.user = user;
		this.books = books;
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
	public List<Book> books(){
		return books;
	}
	//Setters
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
}
