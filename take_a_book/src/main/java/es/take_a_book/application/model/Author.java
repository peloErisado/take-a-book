package es.take_a_book.application.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String surnames;
	private String description;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Book> books;
	
	
	//Constructor
	public Author() {
	}
	
	public Author(String name, String surnames, String description) {
		this.name = name;
		this.surnames = surnames;
		this.description = description;
	}
	
	//Getters
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurnames() {
		return surnames;
	}
	public String getDescription() {
		return description;
	}
	public List<Book> getBooks(){
		return books;
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void addBook(Book book) {
		this.books.add(book);
	}
	public void clearBooks() {
		this.books.clear();
	}

}
