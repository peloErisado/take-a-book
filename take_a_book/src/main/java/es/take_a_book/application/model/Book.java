package es.take_a_book.application.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
	
	@Id
	private int ISBN;

	private String title;
	private String genre;
	private String language;
	private String publisher;
	private String synopsis;
	private float price;
	private int year_;
	
	@ManyToMany(mappedBy = "books", cascade=CascadeType.ALL)
	private List<Author> authors;
	@OneToMany(mappedBy = "book", cascade=CascadeType.ALL)
	private List<Rating> ratings;
	
	
	//Constructor
	public Book() {
	}
	public Book(int ISBN, String title, String genre, String language, String publisher,	
				String synopsis, float price, int year) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.genre = genre;
		this.language = language;
		this.publisher = publisher;
		this.synopsis = synopsis;
		this.price = price;
		this.year_ = year;
	}
	

	
	//Getters
	public int getISBN() {
		return ISBN;
	}
	public int getYear() {
		return year_;
	}
	public float getPrice() {
		return price;
	}
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public String getLanguage() {
		return language;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public List<Author> getAuthors(){
		return authors;
	}
	public List<Rating> getRatings(){
		return ratings;
	}
	
	//Setters
	public void setYear(int year) {
		this.year_ = year;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public void setAuthors(List <Author> authors) {
		this.authors = authors;
	}
	
}
