package com.example.lynx_pratica2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private Integer id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private Integer stock;

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<BookOrder> bookOrders;

    public void addOrder(BookOrder bookOrder){
        if (bookOrders == null) {
            bookOrders=new ArrayList<>();
        }
        bookOrders.add(bookOrder);
    }


}
