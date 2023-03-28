package es.take_a_book.application.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.Rating;
import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.BookService;
import es.take_a_book.application.service.RatingService;
import es.take_a_book.application.service.UserService;

@Controller
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/rating_form")
	public String signupForm(Model model, @RequestParam int ISBN, @RequestParam int ratingScore, @RequestParam String description,
			@RequestParam String username) throws IOException{
		
		Users user = userService.findById(username).get();
		Optional <Book> book = bookService.findById(ISBN);
		
		if(book.isPresent()) {
			Rating rating = new Rating(book.get(), description, ratingScore, user);
			ratingService.save(rating);
			book.get().addRating(rating);
			bookService.save(book.get());
			//model.addAttribute("description", description);
			return "redirect:/books/" + ISBN;
		}else {
			return "errorNotFound";
		}
	}
	
}
