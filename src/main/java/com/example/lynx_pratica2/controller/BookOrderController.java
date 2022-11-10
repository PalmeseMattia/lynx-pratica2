package com.example.lynx_pratica2.controller;

import com.example.lynx_pratica2.entity.BookOrder;
import com.example.lynx_pratica2.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/order/book/")
public class BookOrderController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private BookOrderService bookOrderService;

	@PostMapping("new/{book_id}/{size}")
	public Boolean newOrder(@PathVariable("book_id") Integer bookId,
							@PathVariable Integer size) {
		return bookOrderService.newOrder(bookId,size);
	}

	@GetMapping("{id}")
	public BookOrder getOrder(@PathVariable Integer id){

		return bookOrderService.getOrder(id);
	}



}
