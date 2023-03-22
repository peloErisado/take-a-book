package es.take_a_book.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup_presentation")
	public String signUpPresentation() {
		return "signUp_template";
	}

	@PostMapping("/signup_form")
	public String signUpForm(Model model, @RequestParam String username, @RequestParam String mail, @RequestParam String address, @RequestParam String password, @RequestParam boolean admin) {
		
		Optional<Users> user_ = userService.findById(username);
		
		if(user_.isEmpty()) {
			Users user = new Users(username, passwordEncoder.encode(password), mail, address);
			user.getRoles().add("USER");
			if (admin) user.getRoles().add("ADMIN"); 
			userService.save(user);
			model.addAttribute("user", user);
			return "login_complete";
		}
		
		return "login_complete";
	}
}
