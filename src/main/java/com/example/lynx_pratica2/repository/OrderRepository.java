package com.example.lynx_pratica2.repository;

import com.example.lynx_pratica2.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderBook,Integer> {
}
