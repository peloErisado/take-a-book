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
import es.take_a_book.application.service.BookService;
import es.take_a_book.application.service.RatingService;

@Controller
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	@Autowired
	private BookService bookService;
	
	@PostMapping("/rating_form")
	public String signupForm(Model model, @RequestParam int ISBN, @RequestParam int ratingScore, @RequestParam String description) 
		throws IOException{
		
		Optional <Book> book = bookService.findById(ISBN);
		
		if(book.isPresent()) {
			Rating rating = new Rating(book.get(), description, ratingScore);
			ratingService.save(rating);
			book.get().addRating(rating);
			model.addAttribute("ratingScore", ratingScore);
			model.addAttribute("description", description);
			return "redirect:/books/" + ISBN;
			
		}else {
			return "errorNotFound";
		}
	}
	
}
