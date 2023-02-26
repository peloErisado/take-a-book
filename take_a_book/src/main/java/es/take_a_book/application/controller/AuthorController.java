package es.take_a_book.application.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.service.AuthorService;
import es.take_a_book.application.service.BookService;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	//Authors
	@GetMapping("")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "show_authors";
	}
	
	@GetMapping("/{id}")
	public String getAuthor(Model model, @PathVariable Long id) {
		
		Optional<Author> author = authorService.findById(id);
		
		if (author.isPresent()) {
			model.addAttribute("author", author.get());
			model.addAttribute("books", author.get().getBooks());
			return "show_author";
		}else {
			return "show_authors";
		}
	}
	
	@GetMapping("/{id}/edit")
	public String editAuthor(Model model, @PathVariable Long id) {
		model.addAttribute("author", authorService.findById(id).get());
		return "edit_author";
	}
	
	@PostMapping("/new")
	public String newAuthor(Model model, @PathVariable String name, 
				@PathVariable String surnames, @PathVariable String description) throws IOException{
		authorService.save(new Author(name, surnames, description));
		return "show_authors";
	}
	
	@PostMapping("/{id}/edited")
	public String editedAuthor(Model model, @PathVariable Long id, @PathVariable Optional<String> name,
				@PathVariable Optional<String> surnames, @PathVariable Optional<String> description,
				@PathVariable Optional<Integer> book_ISBN) throws IOException{
		
		model.addAttribute("authors", authorService.findAll());
		
		Optional<Author> author = authorService.findById(id);
		
		if(!author.isPresent()) return "show_authors";
		
		if(!name.isEmpty()) author.get().setName(name.get());
		
		if(!surnames.isEmpty()) author.get().setSurnames(surnames.get());
		
		if(!description.isEmpty()) author.get().setDescription(description.get());
		
		if(!book_ISBN.isEmpty()) {
			Optional<Book> book = bookService.findById(book_ISBN.get());
			if(book.isPresent()) authorService.addBook(id, book.get());
		}
		
		return "show_authors";
	}
}
