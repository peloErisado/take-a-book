package es.take_a_book.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
	/*@GetMapping("/greeting")
	public String home(Model model) {
		model.addAttribute("name", "Mundo");
		return "greeting_template";
	}*/
	
	@PostMapping("/signup-form")
	public String signupForm(Model model, @RequestParam String username, @RequestParam String mail, @RequestParam String address, @RequestParam String password) {
		
		model.addAttribute("username", username);
		model.addAttribute("mail", mail);
		model.addAttribute("address", address);
		model.addAttribute("password", password);
		
		return "greeting_template";
	}
}