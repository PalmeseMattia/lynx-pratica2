package com.example.lynx_pratica2.service;

import com.example.lynx_pratica2.entity.Book;
import com.example.lynx_pratica2.entity.BookOrder;
import com.example.lynx_pratica2.repository.BookOrderRepository;

import com.example.lynx_pratica2.service.interfaces.IBookOrderService;
import com.example.lynx_pratica2.service.interfaces.IBookService;
import com.example.lynx_pratica2.util.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BookOrderService implements IBookOrderService {

    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Autowired
    private IBookService bookService;

    @Override
    public Boolean newOrder(Integer bookId, Integer size)  {

        Book book= bookService.getBook(bookId);
        if (book == null) {
            throw new RuntimeException("Invalid! Customer Id");
        }

        Integer sum=0;
        if (book.getStock()< size) {
            while ((book.getStock()+sum)< size){
                sum+= MathUtils.randomNumber();
            }
        }

        BookOrder order=new BookOrder();

        order.setBook(book);
        order.setSize(size);
        order.setOrderDate(new Date().getTime());

        if (bookService.updateStock(bookId,size,sum)) {
            bookOrderRepository.save(order);
            return true;
        }

        return false;
    }

    @Override
    public BookOrder getOrder(Integer id) {
        Optional<BookOrder> bookOrder=bookOrderRepository.findById(id);
        return bookOrder.get();
    }
}
