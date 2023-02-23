package es.take_a_book.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.Purchase;
import es.take_a_book.application.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	//DISPLAYS: your purchase 
	@GetMapping("/purchase/{billNumber}")
	public String getPurchaseSummary(Model model, @PathVariable long billNumber) {
		Optional<Purchase> purchase = purchaseService.findById(billNumber);
		
		if (purchase.isPresent()) {
			model.addAttribute("book", purchase.get());
			return "purchase_template";
		} else { 
			return "errorNotFound";
		}
		
	}
	
	@PostMapping("/finish-purchase")
	public String paymentForm(Model model, @RequestParam String payment) {
		
		model.addAttribute("payment", payment);
		
		return "thanking_template";
	}
}