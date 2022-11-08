package com.example.lynx_pratica2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private Long id;

    @Column
    private String book;

    @Column(name="order_quantity")
    private Integer orderedQuantity;

    @Column(name="order_date")
    private Date orderDate;


}
