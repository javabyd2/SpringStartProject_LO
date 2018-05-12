package com.sda.spring.demo.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "bookAuthors")
    private Set<Book> books;


}
