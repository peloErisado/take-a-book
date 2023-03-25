package es.take_a_book.application.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.take_a_book.application.internal_service.Producer;
import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.UserService;
import es.take_a_book.application.security.CSRFHandler;
import org.springframework.security.web.csrf.CsrfToken;

@Controller
@RequestMapping("/users")
public class SignUpController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Producer producer;
	
	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();

		if (principal != null) {

			model.addAttribute("logged", true);
			model.addAttribute("userName", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));

		} else {
			model.addAttribute("logged", false);
			model.addAttribute("userName","Invitado");
		}
	}
	
	@GetMapping("/signup_presentation")
	public String signUpPresentation(Model model) {
		
		//CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		//model.addAttribute("token", token.getToken());
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
			
			producer.sendSignUpMessage(user);
			
			return "login_complete";
		}
		
		return "login_complete";
	}
	
}
