package es.take_a_book.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.take_a_book.application.internal_service.Producer;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.Purchase;
import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.PurchaseService;
import es.take_a_book.application.service.UserService;
import es.take_a_book.application.service.BookService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	Producer producer;
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	/*//Authors
	@GetMapping("")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return path+"author_show_multiple";
	}*/
	
	@GetMapping("")
	public String getPurchases(Model model) {
		List<Purchase> aux = new ArrayList<>();
		List<Purchase> purchases = purchaseService.findAll();
		for(Purchase p: purchases) {
			if(p.isPurchased()) {
				p.calculateTotalPrice();
				aux.add(p);
			}
		}
		model.addAttribute("purchasesExist", !aux.isEmpty());
		model.addAttribute("purchases", aux);
		return "/purchase_HTML/purchase_show_multiple";
	}
	
	@GetMapping("/cart")
	public String shoppingCart(Model model) {
		Optional <Users> user = userService.findById((String)model.getAttribute("mv_username"));
		List<Purchase> purchases = user.get().getPurchases();
		
		if(!purchases.isEmpty()) {
			Purchase p = purchases.get(purchases.size()-1);
			p.calculateTotalPrice();
			purchaseService.save(p);
			if(!p.isPurchased()) {
				model.addAttribute("purchase",p);
				model.addAttribute("anyBook", !p.getBooks().isEmpty());
			}else {
				model.addAttribute("anyBook", false);
			}
		}else {
			model.addAttribute("anyBook", false);
		}
		return "/purchase_HTML/cart";
	}

	//DISPLAYS: your purchase 
	@GetMapping("/{billNumber}")
	public String getPurchaseSummary(Model model, @PathVariable long billNumber) {
		Optional<Purchase> purchase = purchaseService.findById(billNumber);
		
		if (purchase.isPresent()) {
			model.addAttribute("book", purchase.get());
			return "/purchase_HTML/showPurchase";
		} else { 
			return "errorNotFound";
		}
	}
	
	@GetMapping("/finish_purchase/{billNumber}")
	public String finishPurchaseScreen(Model model, @PathVariable long billNumber) {
		Optional<Purchase> purchase = purchaseService.findById(billNumber);
		
		if(purchase.isEmpty()) return "errorNutFound";
		
		model.addAttribute("purchase", purchase.get());
		return "/purchase_HTML/pay_purchase";
	}
	
	@PostMapping("/finish_purchase")
	public String finishPurchase(Model model) {
		Optional <Users> user = userService.findById((String)model.getAttribute("mv_username"));
		List<Purchase> purchases = user.get().getPurchases();
		Purchase p = purchases.get(purchases.size()-1);
		p.setPurchased(true);
		purchaseService.save(p);
		userService.save(user.get());
		return "/purchase_HTML/thanking_template";
	}
	
	@PostMapping("/finish_purchase/{billNumber}")
	public String paymentForm(Model model, @PathVariable long billNumber, @RequestParam String payment) {
		
		Optional <Users> user = userService.findById((String)model.getAttribute("mv_username"));
		Optional<Purchase> purchase = purchaseService.findById(billNumber);
		
		purchase.get().setPayment(payment);
		purchase.get().setPurchased(true);
		
		purchaseService.save(purchase.get());
		userService.save(user.get());
		
		producer.sendPurchaseMessage(user.get(), purchase.get());
		
		return "redirect:/books";
	}
}