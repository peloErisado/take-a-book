package es.take_a_book.application.model;
import java.util.List;
import javax.persistence.*;


@Entity
public class Users {
	
	@Id
	private String username;
	
	private String password;
	private String mail;
	private String address;

	@OneToMany(mappedBy="user")
	private List<Purchase> purchases;
	@OneToMany(mappedBy="user") 
	private List<Rating> ratings;
	@OneToOne(mappedBy="user")
	private Loan loan;
	
	//Constructor
	public Users(String username, String password, String mail, String address) {
		this.username = username;
		this.password = password;
		this.mail = address;
		this.address = address;
	}
	
	//Getters
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getMail() {
		return mail;
	}
	public String getAddress() {
		return address;
	}
	public List<Purchase> getPurchases(){
		return purchases;
	}
	public List<Rating> getRatings(){
		return ratings;
	}
	public Loan getLoan() {
		return loan;
	}
	//Setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
}
