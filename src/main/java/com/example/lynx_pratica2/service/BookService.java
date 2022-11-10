package com.example.lynx_pratica2.service;

import com.example.lynx_pratica2.entity.Book;
import com.example.lynx_pratica2.repository.BookRepository;

import java.util.Optional;

import com.example.lynx_pratica2.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBook(Integer id) {
    	Optional<Book> n = bookRepository.findById(id);
    	return n.get();
    }

    @Override
    public Integer getStock(Integer id) {
    	Book nBook = this.getBook(id);
    	return nBook.getStock();
    }

    @Override
    public Boolean isEmpty(Integer id) {
        Integer nStock=getStock(id);
        return nStock <= 0;
    }
    @Override
    public Boolean existed(Integer id){
        Book nBook = this.getBook(id);
        if (nBook == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateStock(Integer id, Integer num, Integer newStockRequested) {
        Book nBook = this.getBook(id);

        if(!existed(id)){
            return false;
        }
        Integer oldStock=nBook.getStock();
        Integer newStock=oldStock +newStockRequested-num;

        if (newStock*(-1)>0) {
            return false;
        }

        nBook.setStock(newStock);
        bookRepository.save(nBook);

        return true;
    }

}
