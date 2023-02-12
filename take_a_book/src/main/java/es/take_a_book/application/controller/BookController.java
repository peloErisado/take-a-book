package es.take_a_book.application.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.take_a_book.application.model.Book;
import repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	/*
	@Autowired 
	private BookRepository books;
	
	@PostConstruct 
	public void init() {
		books.save(new Book(232, "Estelar", "Ciencia ficción", "Castellano", "Ediciones B"
				,"Sinopsis", (float) 18.90, 2020));
	}
	
	@GetMapping("/")
	public Collection<Book> getBooks(){
		return books.findAll();
	}
	*/
}
