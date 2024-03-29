package es.take_a_book.application.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.take_a_book.application.internal_service.Producer;
import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.LoanService;
import es.take_a_book.application.service.UserService;


@Controller
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private UserService userService;
	
	private String path = "loan_HTML/";
	
	//Loans
	@GetMapping("")
	public String getLoans(Model model) {
		Optional <Users> user = userService.findById((String)model.getAttribute("mv_username"));
		model.addAttribute("loans", user.get().getLoans());
		model.addAttribute("loansExist", user.get().getLoans().isEmpty());
		return path+"loan_show_multiple";
	}
	
	@GetMapping("/{numResguardo}")
	public String getLoan(Model model, @PathVariable long numResguardo) {
		
		Optional<Loan> loan = loanService.findById(numResguardo);

		if (loan.isPresent()) {
			model.addAttribute("loan", loan.get());
			return path+"loan_show_single";
		}else {
			return path+"loan_show_multiple";
		}
	}
		
}