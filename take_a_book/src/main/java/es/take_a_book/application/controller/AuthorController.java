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
	
	private String path = "author_HTML/";
	
	//Authors
	@GetMapping("")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return path+"author_show_multiple";
	}
	
	@GetMapping("/{id}")
	public String getAuthor(Model model, @PathVariable Long id) {
		
		Optional<Author> author = authorService.findById(id);
		
		if (author.isPresent()) {
			model.addAttribute("author", author.get());
			model.addAttribute("books", author.get().getBooks());
			return path+"author_show_single";
		}else {
			return path+"author_show_multiple";
		}
	}
	
	@GetMapping("/new")
	public String newAuthorPage() {
		return path+"author_add";
	}
	
	@PostMapping("/new")
	public String newAuthor(Model model, String name, String surnames, String description) throws IOException{
		authorService.save(new Author(name, surnames, description));
		model.addAttribute("authors", authorService.findAll());
		return path+"author_show_multiple";
	}
	
	@GetMapping("/{id}/edit")
	public String editAuthor(Model model, @PathVariable Long id) {
		model.addAttribute("author", authorService.findById(id).get());
		return path+"author_edit";
	}
	
	@PostMapping("/{id}/edit")
	public String editedAuthor(Model model, @PathVariable Long id, String name, String surnames, String description, Integer book_ISBN) throws IOException{
		
		model.addAttribute("authors", authorService.findAll());
		
		Optional<Author> author = authorService.findById(id);
		
		if(!author.isPresent()) return "author_HTML/show_authors";
		
		author.get().setName(name);
		
		author.get().setSurnames(surnames);
		
		author.get().setDescription(description);
		
		if(book_ISBN > 0) {
			Optional<Book> book = bookService.findById(book_ISBN);
			if(book.isPresent()) authorService.addBook(id, book.get());
		}
		
		authorService.save(author.get());
		
		return path+"author_show_multiple";
	}
	
	@GetMapping("/{id}/remove_confirm")
	public String deleteAuthorPage(Model model, @PathVariable Long id) {
		model.addAttribute("author", authorService.findById(id).get());
		return path+"author_remove";
	}
	
	@GetMapping("/{id}/remove")
	public String deleteAuthor(Model model, @PathVariable Long id) {
		Optional<Author> author = authorService.findById(id);
		if(author.isPresent()) authorService.delete(author.get());
		
		model.addAttribute("authors", authorService.findAll());
		
		return path+"author_show_multiple";
	}
}
