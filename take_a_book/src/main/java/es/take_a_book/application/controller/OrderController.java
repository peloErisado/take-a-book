package es.take_a_book.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("")
	public String choseTypeOrder(Model model) {
		//model.addAttribute("name", "Mundo");
		return "orderType";
	}
	
}
