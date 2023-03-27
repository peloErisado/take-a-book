package es.take_a_book.application.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.UserService;
import es.take_a_book.application.security.CSRFHandler;
import org.springframework.security.web.csrf.CsrfToken;


@ControllerAdvice
@RequestMapping("/users")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();
		
		
		if (principal != null) {
			model.addAttribute("mv_logged", true);
			model.addAttribute("mv_username", principal.getName());
			model.addAttribute("mv_admin", request.isUserInRole("ADMIN"));

		} else {
			model.addAttribute("mv_logged", false);
		}
	}
	
	@RequestMapping("/login_template")
	public String loginTemplate() {
		//model.addAttribute("invalidLogin", false);
		return "login_template";
	}
	
	@RequestMapping("/login_error")
	public String loginError() {
		return "login_error";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request) throws ServletException {	
		request.logout();
		return "logout_template";
	}
	
	
	
	/*
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
	*/
}
