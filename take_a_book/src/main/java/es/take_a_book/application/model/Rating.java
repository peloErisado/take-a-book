package es.take_a_book.application.model;

import javax.persistence.*;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String description;
	private int ratingScore;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Book book;
	
	//Constructor
	public Rating(Book book, User user, String description, int ratingScore) {
		this.book = book;
		this.user = user;
		this.description = description;
		this.ratingScore = ratingScore;
	}
	
	//Getters
	public long getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public int ratingScore() {
		return ratingScore;
	}
	public User getUser() {
		return user;
	}
	public Book getBook() {
		return book;
	}
	//Setters
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
	
}
