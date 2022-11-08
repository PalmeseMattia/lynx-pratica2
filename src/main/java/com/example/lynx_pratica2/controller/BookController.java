package com.example.lynx_pratica2.controller;


import com.example.lynx_pratica2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/stock/{id}")
    public Integer getStockBook(@PathVariable Integer id){
        return null;
    }
}
