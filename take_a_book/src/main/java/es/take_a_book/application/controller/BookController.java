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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.service.BookService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private String path = "book_HTML/";
	
	//private static final String BOOKS_FOLDER = "books";
	@Autowired
	private BookService bookService;

	//DISPLAYS: Every book
	@GetMapping("")
	public String getBooks(Model model){
		model.addAttribute("books", bookService.findAll());
		return path+"showBooks";
	}
	
	//REDIRECTS: To adding books page
	@GetMapping("/new")
	public String showAddBookScreen() {
		return path+"addBook";
	}
	
	//CREATES: A new book
	@PostMapping("/new")
	public String addNewBook(@RequestParam int ISBN, @RequestParam String title, @RequestParam String genre,
			@RequestParam String language, @RequestParam String publisher, @RequestParam String synopsis, @RequestParam float price, 
			@RequestParam int year){
		
		Optional <Book> book = bookService.findById(ISBN);
		
		bookService.save(new Book(ISBN, title, genre, language, publisher, synopsis, price, year));
		
		return "redirect:"+path+"/books/"+ISBN;
	}


	//DISPLAYS: Selected book by id
	@GetMapping("/{ISBN}")
	public String getBook(Model model, @PathVariable int ISBN) {
		
		Optional<Book> book = bookService.findById(ISBN);

		if (book.isPresent()) {
			model.addAttribute("book", book.get());
			return path+"showBook";
		}else {
			return path+"showBooks";
		}
	}

	//DOWNLOADS: A book's image
	@GetMapping("/{ISBN}/image")
	public ResponseEntity<Object> downloadImage(@PathVariable int ISBN) throws SQLException {

		Optional <Book> book = bookService.findById(ISBN);
		
		if(book.isEmpty() || book.get().getImageFile() == null) return ResponseEntity.notFound().build();
		
		Resource file = new InputStreamResource (book.get().getImageFile().getBinaryStream());
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpg")
				.contentLength(book.get().getImageFile().length()).body(file);
	}
	
	@PostMapping("/{ISBN}/image")
	public ResponseEntity<Object> uploadImage (Model model, @PathVariable Integer ISBN, 
										@RequestBody MultipartFile image) throws IOException {
		
		Optional<Book> book = bookService.findById(ISBN);
		if(book.isEmpty()) return ResponseEntity.notFound().build();
		/*=======================================*/
		book.get().setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
		System.out.println("\n"+image.getSize());
		bookService.save(book.get());
		/*=======================================*/
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{ISBN}/image")
	public ResponseEntity<Object> deleteImage (Model model, @PathVariable Integer ISBN) {
		
		Optional<Book> book = bookService.findById(ISBN);
		if(book.isEmpty() || book.get().getImageFile() == null) return ResponseEntity.notFound().build();
		
		book.get().setImageFile(null);
		bookService.save(book.get());
		
		return ResponseEntity.ok().build();
	}
}
