package com.example.lynx_pratica2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private Integer stock;


}
