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
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostConstruct
	void init() {
		authorService.save(new Author("Brandon", "Sanderson", "Un escritor estadounidense muy bueno en su trabajo."));
	}
	
	//Authors
	@GetMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "showAuthors";
	}
}
