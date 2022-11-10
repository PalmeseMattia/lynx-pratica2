package com.example.lynx_pratica2.service.interfaces;

import com.example.lynx_pratica2.entity.BookOrder;

import java.util.Optional;

public interface IBookOrderService {
    Boolean newOrder(Integer bookId, Integer size);

    BookOrder getOrder(Integer id);
}
