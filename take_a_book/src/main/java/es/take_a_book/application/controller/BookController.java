package es.take_a_book.application.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

import java.time.LocalDate;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import es.take_a_book.application.model.Book;

import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.Purchase;
import es.take_a_book.application.service.AuthorService;

import es.take_a_book.application.service.BookService;
import es.take_a_book.application.service.LoanService;
import es.take_a_book.application.service.PurchaseService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
@Controller
@RequestMapping("/books")
public class BookController {
	
	//private static final String BOOKS_FOLDER = "books";
	@Autowired
	private BookService bookService;

	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired 
	private PurchaseService purchaseService;
	

	private String path = "/book_HTML/";
	
	

	//REDIRECTS: To adding books page
	@GetMapping("/new")
	public String showAddBookScreen() {
		return "addBook";
	}
	
	//CREATES: A new book
	@PostMapping("/new")
	public String addNewBook(@RequestParam int ISBN, @RequestParam String title, @RequestParam String genre,
			@RequestParam String language, @RequestParam String publisher, @RequestParam String synopsis, @RequestParam float price, 
			@RequestParam int year){
		Optional <Book> book = bookService.findById(ISBN);
		//if(!bookService.isPresent()) {
			bookService.save(new Book(ISBN, title, genre, language, publisher, synopsis, price, year));
		return "redirect:/books/"+ISBN;
	}
	
	//DISPLAYS: Every book
	@GetMapping("")
	public String getBooks(Model model){
		model.addAttribute("books", bookService.findAll());
		return "showBooks";
	}


	//DISPLAYS: Selected book by id
	@GetMapping("/{ISBN}")
	public String getBook(Model model, @PathVariable int ISBN) {
		
		Optional<Book> book = bookService.findById(ISBN);

		if (book.isPresent()) {
			model.addAttribute("book", book.get());
			return "showBook";
		}else {
			return "showBooks";
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
/*
	//UPLOADS: A book's image

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
			String language, String publisher, String synopsis, Float price, Integer year, Long author_id) throws IOException{
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
		if(author.isPresent()) bookService.addAuthor(ISBN, author.get());
		
		bookService.save(book.get());
		
		return path+"showBooks";
	}

	@GetMapping("/{ISBN}/loan")
	public String loanBook(@PathVariable int ISBN) {
		
		Optional<Book> book = bookService.findById(ISBN);
		
		LocalDate inicio = LocalDate.now();
		LocalDate fin = inicio.plusMonths(2);
		
		loanService.save(new Loan(book.get(),inicio.toString(), fin.toString()));
		return "loan_HTML/loan_complete";
	}
	
	@GetMapping("/{ISBN}/purchase")
	public String purchaseBook(Model model, @PathVariable int ISBN) {
		
		Optional<Book> book = bookService.findById(ISBN);
		
		Purchase p = new Purchase(book.get(), "");
		
		purchaseService.save(p);
		
		model.addAttribute("purchase", p);
		model.addAttribute("book", book.get());
	
		return "purchase_HTML/showPurchase";
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
