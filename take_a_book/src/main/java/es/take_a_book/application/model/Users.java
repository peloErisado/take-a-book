package es.take_a_book.application.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Users {
	
	@Id
	private String username;
	
	private String password;
	private String mail;
	private String address;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Purchase> purchases;
	@OneToMany(mappedBy="user")
	private List<Rating> ratings;
	@OneToMany(mappedBy="user")
	private List<Loan> loans;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	//Constructor
	public Users() {
		
	}
	
	public Users(String username, String password, String mail, String address) {
		roles = new ArrayList<String>();
		loans = new ArrayList<Loan>();
		purchases = new ArrayList<Purchase>();
		
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
	public List<Loan> getLoans() {
		return loans;
	}
	public List<String> getRoles(){
		return roles;
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

}
