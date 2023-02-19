package es.take_a_book.application.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.service.BookService;


@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostConstruct
	void init() {
		bookService.save(new Book(9293, "Titulo1", "Genero1", "Lengua1", "Publisher1", "Sinopsis1", (float)18.90, 1923));
		bookService.save(new Book(9294, "Titulo2", "Genero2", "Lengua2", "Publisher2", "Sinopsis2", (float)19.90, 1924));
	}
	//CREATES: A book
	
	
	//DISPLAYS: Every book
	@GetMapping("/books")
	public String getBooks(Model model){
		model.addAttribute("books", bookService.findAll());
		return "showBooks";
	}
	
	//DISPLAYS: Selected book by id
	@GetMapping("/books/{id}")
	public String getBook(Model model, @PathVariable int id) {
		
		Optional<Book> book = bookService.findById(id);
		
		if (book.isPresent()) {
			model.addAttribute("book", book.get());
			return "showBook";
		} else { 
			return "showBooks";
		}
	}
	
	
	
	
}
