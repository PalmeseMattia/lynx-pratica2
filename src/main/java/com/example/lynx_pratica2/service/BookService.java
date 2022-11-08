package com.example.lynx_pratica2.service;

import com.example.lynx_pratica2.entity.Book;
import com.example.lynx_pratica2.repository.BookRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    public Book get(Integer id) {
    	Optional<Book> n = bookRepository.findById(id);
    	return n.get();
    }
    
    public String getStock(Integer id) {
    	Book nBook = this.get(id);
    	return nBook.getStock().toString();
    }
}
