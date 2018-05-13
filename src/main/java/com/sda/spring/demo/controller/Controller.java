package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.BookCategory;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello word";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> showBookList(){
        return bookService.getBooks();
    }

    /*
     - wszystkich autorow
     - wszystkich kategorii
     */

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<BookCategory> showCategories(){
        return categoryService.getCategories();
    }
}
