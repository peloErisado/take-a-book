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
import es.take_a_book.application.service.BookService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private BookService bookService;
	
	/*//Authors
	@GetMapping("")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return path+"author_show_multiple";
	}*/
	
	@GetMapping("")
	public String getPurchases(Model model) {
		model.addAttribute("purchases", purchaseService.findAll());
		return "purchase_HTML/purchase_show_multiple";
	}
	
	
	//DISPLAYS: your purchase 
	@GetMapping("/purchase/{billNumber}")
	public String getPurchaseSummary(Model model, @PathVariable long billNumber) {
		Optional<Purchase> purchase = purchaseService.findById(billNumber);
		
		if (purchase.isPresent()) {
			model.addAttribute("book", purchase.get());
			return "purchase_HTML/showPurchase";
		} else { 
			return "errorNotFound";
		}
		
	}
	
	@PostMapping("/finish_purchase/{billNumber}")
	public String paymentForm(Model model, @PathVariable long billNumber, @RequestParam String payment) {
		
		Optional<Purchase> purchase = purchaseService.findById(billNumber);
		
		model.addAttribute("payment", payment);
		
		purchase.get().setPayment(payment);
		
		purchaseService.save(purchase.get());
		
		return "purchase_HTML/thanking_template";
	}
}