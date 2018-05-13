package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.BookAuthor;
import com.sda.spring.demo.model.BookCategory;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello word";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> showBookList(){
        return bookService.getBooks();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public BookCategory addCategory(
            @RequestBody BookCategory bookCategory
                                    ){
        return categoryService.save(bookCategory);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book addBook(
            @RequestBody Book book
    ){
        return bookService.save(book);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    /*
     - wszystkich autorow
     - wszystkich kategorii
     */

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<BookCategory> showCategories(){
        return categoryService.bookCategories();
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<BookAuthor> showAuthors(){
        return authorService.getAuthors();
    }
}
