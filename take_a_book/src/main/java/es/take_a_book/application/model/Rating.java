package es.take_a_book.application.model;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String description;
	private int ratingScore;
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Users user;
  
	@ManyToOne(fetch = FetchType.EAGER)
	private Book book;
	
	//Default constructor
	public Rating() {}
	//Constructor
	public Rating(Book book, String description, int ratingScore, Users user) {
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
	public Users getUser() {
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
