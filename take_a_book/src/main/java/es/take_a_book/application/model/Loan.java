package es.take_a_book.application.model;

import javax.persistence.*;


@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numResguardo;
	
	private String fechaInicio;
	private String fechaFin;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Users user;
	@OneToOne(cascade=CascadeType.ALL)
	private Book book;
	
	public Loan() {};
	
	//Constructor
	public Loan(/*Users user,*/ Book book, String fechaInicio, String fechaFin) {
		//this.user = user;
		this.book = book;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	//Getters
	public long getNumResguardo() {
		return numResguardo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public Users getUser() {
		return user;
	}
	public Book getBook() {
		return book;
	}
	
	//Setters
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
