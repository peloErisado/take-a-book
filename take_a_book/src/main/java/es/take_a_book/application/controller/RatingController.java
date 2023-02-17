package es.take_a_book.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {
	
	@PostMapping("/rating-form")
	public String signupForm(Model model, @RequestParam int ratingScore, @RequestParam String[] description) {
		
		model.addAttribute("ratingScore", ratingScore);
		model.addAttribute("description", description);
		
		return "thankRating_template";
	}
}
