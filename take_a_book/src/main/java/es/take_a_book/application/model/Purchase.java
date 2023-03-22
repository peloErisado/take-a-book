package es.take_a_book.application.model;

import java.util.ArrayList;
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
	private boolean purchased = false;
	@ManyToOne
	private Users user;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Book> books;
	
	public Purchase() {};
	
	//Constructor
	public Purchase(Users user) {
		books = new ArrayList<>();
		this.user = user;

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
	public List<Book> getBooks(){
		return this.books;
	}
	public boolean isPurchased() {
		return this.purchased;
	}
	//Setters
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	
	//Other methods
	public void calculateTotalPrice() {
		totalPrice = 0;
		for(int i = 0; i<books.size(); i++) {
			totalPrice+=books.get(i).getPrice();
		}
	}
	
}
