package com.example.lynx_pratica2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.lynx_pratica2.service.BookService;
import com.example.lynx_pratica2.service.OrderService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/stock/{id}")
	public String getStock(
			@PathVariable("id") Integer id
			) {
		
		return bookService.getStock(id);
	}

}
