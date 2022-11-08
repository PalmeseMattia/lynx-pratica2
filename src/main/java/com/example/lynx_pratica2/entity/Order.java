package com.example.lynx_pratica2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Table(name="order_book")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private Integer id;

    @ManyToMany(mappedBy = "orders")
    private List<Book> book;

    @Column(name="ordered_size")
    private Integer orderedQuantity;

    @Column(name="order_date")
    private Date orderDate;


}
