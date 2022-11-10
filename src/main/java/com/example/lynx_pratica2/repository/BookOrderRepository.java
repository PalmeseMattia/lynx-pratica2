package com.example.lynx_pratica2.repository;

import com.example.lynx_pratica2.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {
}
