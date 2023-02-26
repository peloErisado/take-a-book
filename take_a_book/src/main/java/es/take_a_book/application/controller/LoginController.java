package es.take_a_book.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.UserService;



@Controller
@RequestMapping("/users")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login_template")
	public String loginTemplate(Model model) {
		model.addAttribute("invalidLogin", false);
		return "login_template";
	}
	
	@GetMapping("/login_form")
	public String loginForm(Model model, @RequestParam String username, @RequestParam String password) {
		
		Optional<Users> user = userService.findById(username);

		if(!user.isEmpty() && user.get().getPassword().equals(password)) {
			model.addAttribute("user", user.get());
			return "login_complete";
		}else {
			model.addAttribute("invalidLogin", true);
			return "login_template";
		}
	}
}
