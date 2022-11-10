package com.example.lynx_pratica2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="book_id")
    @JsonIgnore
    private Book book;

    @Column
    private Integer size;

    @Column
    private Long orderDate;


}
