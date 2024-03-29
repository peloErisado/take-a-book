package es.take_a_book.application.model;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book{
	
	@Id
	private int ISBN;

	private String title;
	private String genre;
	private String language;
	private String publisher;
	private String synopsis;
	private float price;
	private int year_;
	private String image;
	
	@Lob
	@JsonIgnore
	private Blob imageFile;
	
	@ManyToMany(mappedBy = "books")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Author> authors = new ArrayList<>();
	
	@OneToMany(mappedBy = "book")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Rating> ratings = new ArrayList<>();;
	
	@ManyToMany(mappedBy = "books")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Purchase> purchases;
	
	
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
	//@JsonManagedReference
	public List<Author> getAuthors(){
		return authors;
	}
	//@JsonManagedReference
	public List<Rating> getRatings(){
		return ratings;
	}
	public String getImage() {
		return image;
	}
	public Blob getImageFile() {
		return imageFile;
	}
	@JsonManagedReference
	public List<Purchase> getPurchases(){
		return purchases;
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
	public void setImageFile(Blob imageFile) {
		this.imageFile = imageFile;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void addRating(Rating rating) {
		this.ratings.add(rating);
	}
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	public void clearAuthors() {
		this.authors.clear();
	}
	
}
