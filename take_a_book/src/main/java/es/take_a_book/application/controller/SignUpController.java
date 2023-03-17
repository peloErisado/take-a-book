package es.take_a_book.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.UserService;

@Controller
@RequestMapping("/users")
public class SignUpController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup_presentation")
	public String signUpPresentation() {
		return "signUp_template";
	}
	
	@PostMapping("/signup_form")
	public String signUpForm(Model model, @RequestParam String username, @RequestParam String mail, @RequestParam String address, @RequestParam String password) {
		
		/*
		model.addAttribute("username", username);
		model.addAttribute("mail", mail);
		model.addAttribute("address", address);
		model.addAttribute("password", password);
		*/
		
		Optional<Users> user_ = userService.findById(username);
		
		if(user_.isEmpty()) {
			Users user = new Users(username, password, mail, address);
			userService.save(new Users(username, password, mail, address));
			model.addAttribute("user", user);
			return "login_complete";
		}
		
		return "login_complete";
	}
}
