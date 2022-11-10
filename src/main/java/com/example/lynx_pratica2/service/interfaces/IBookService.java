package com.example.lynx_pratica2.service.interfaces;

import com.example.lynx_pratica2.entity.Book;

public interface IBookService {
    Book getBook(Integer id);
    Integer getStock(Integer id);
    Boolean isEmpty(Integer id);
    Boolean existed(Integer id);
    Boolean updateStock(Integer id, Integer num, Integer newStockRequested);
}
