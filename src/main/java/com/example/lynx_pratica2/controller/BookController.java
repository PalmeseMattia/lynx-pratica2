package com.example.lynx_pratica2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.lynx_pratica2.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/stock/{id}")
	public Integer getStock(
			@PathVariable Integer id
			) {
		
		return bookService.getStock(id);
	}

	@GetMapping("/stock/{id}/isEmpty")
	public Boolean isEmpty(@PathVariable Integer id){
		return bookService.isEmpty(id);
	}

}
