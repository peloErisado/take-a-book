package es.take_a_book.application.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
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
@RequestMapping("/books")
public class BookController {
	
	//private static final String BOOKS_FOLDER = "books";
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	private String path = "/book_HTML/";
	

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
		//Optional <Book> book = bookService.findById(ISBN);
		//if(!bookService.isPresent()) {
			bookService.save(new Book(ISBN, title, genre, language, publisher, synopsis, price, year));
		return "redirect:/books/"+ISBN;
	}
	
	//DISPLAYS: Every book
	@GetMapping("")
	public String getBooks(Model model){
		model.addAttribute("books", bookService.findAll());
		return path+"showBooks";
	}


	//DISPLAYS: Selected book by id
	@GetMapping("/{ISBN}")
	public String getBook(Model model, @PathVariable int ISBN) {
		
		Optional<Book> book = bookService.findById(ISBN);

		if (book.isPresent()) {
			if(!book.get().getRatings().isEmpty()) {
				model.addAttribute("ratings", book.get().getRatings());
				model.addAttribute("rated", true);
			}else {
				model.addAttribute("rated", false);
			}
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

		if (book.isPresent() && book.get().getImageFile() != null) {

			Resource file = new InputStreamResource(book.get().getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					.contentLength(book.get().getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	//UPLOADS: A book's image
/*¡
	@PostMapping("/books/{ISBN}/image")
	public ResponseEntity<Object> uploadImage(@PathVariable int ISBN,
		 @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		
		 Book book = bookService.findById(ISBN).orElseThrow();
		 URI location = fromCurrentRequest().build().toUri();
		 book.setImage(location.toString());
	
		 book.setImageFile(BlobProxy.generateProxy(
		 imageFile.getInputStream(), imageFile.getSize()));
		 bookService.save(book);
		 System.out.printf("Archivo subido");
		 return ResponseEntity.created(location).build();
		 
	}
*/	
	@GetMapping("/{ISBN}/edit")
	public String editAuthor(Model model, @PathVariable int ISBN) {
		List <Author> authors = authorService.findAll();
		if(!authors.isEmpty()) {
			model.addAttribute("allAuthors", authors);
		}
		model.addAttribute("book", bookService.findById(ISBN).get());
		return path+"edit_book";
	}
	
	@PostMapping("/{ISBN}/edited")
	public String editedBook(Model model,@PathVariable int ISBN, String title, String genre,
			String language, String publisher, String synopsis, Float price, Integer year, @RequestParam("author_id") Long author_id) throws IOException{
		model.addAttribute("books", bookService.findAll());
		
		Optional<Book> book = bookService.findById(ISBN);
		
		if(!book.isPresent()) return "showBooks";
		
		book.get().setTitle(title);
		
		book.get().setGenre(genre);
		
		book.get().setLanguage(language);
		
		book.get().setPublisher(publisher);
		
		book.get().setSynopsis(synopsis);
		
		book.get().setPrice(price);
		
		book.get().setYear(year);
		
		Optional<Author> author = authorService.findById(author_id);
		if(author.isPresent()) { 
			bookService.addAuthor(ISBN, author.get());
			authorService.addBook(author_id, book.get());
		}
		bookService.save(book.get());
		authorService.save(author.get());
		
		return path+"showBooks";
	}

	@GetMapping("/{ISBN}/remove_confirm")
	public String deleteBookPage(Model model, @PathVariable int ISBN) {
		model.addAttribute("book", bookService.findById(ISBN).get());
		return path+"book_remove";
	}
	
	@GetMapping("/{ISBN}/remove")
	public String deleteBook(Model model, @PathVariable int ISBN) {
		Optional<Book> book = bookService.findById(ISBN);

		if(book.isPresent()) bookService.delete(book.get());
		
		model.addAttribute("books", bookService.findAll());
		
		return path+"showBooks";
	}
	
	/*
	@PostMapping("/books/{id}/image")
	public ResponseEntity<Object> uploadImage(@PathVariable int ISBN, @RequestParam MultipartFile imageFile) throws IOException {
		 Optional <Book> book = bookService.findById(ISBN);
		 if (book.isPresent()) {
			 URI location = fromCurrentRequest().build().toUri();
			 book.get().setImage(location.toString());
			 bookService.save(book.get());
			 imgService.saveImage(BOOKS_FOLDER, book.get().getISBN(), imageFile);
			 return ResponseEntity.created(location).build();
		 } else {
		return ResponseEntity.notFound().build();
		 }
	}
	*/

	
	
	
	
}
