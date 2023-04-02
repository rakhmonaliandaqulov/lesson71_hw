package com.example.controller;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;
    private List<BookDto> bookdtoList = new LinkedList<>();
    public BookController() {
        BookDto b1 = new BookDto();
        b1.setId(10);
        b1.setTitle("JAva");
        b1.setAuthor("A.Aliyev");
        b1.setAmount(12);
        b1.setPublishYear("2003-yil");
        b1.setVisible(Boolean.TRUE);

        bookService.addBook(b1);
    }
    @GetMapping(value = "/list")
    public List<BookEntity> getAll() {
        return bookService.bookList();
    }

    @GetMapping(value = "/get/{id}")
    public BookEntity getById(@PathVariable("id") Integer id) {
        Optional<BookEntity> optional = bookService.bookList().stream()
                .filter(studentDTO -> studentDTO.getId().equals(id))
                .findAny();
        return optional.orElse(null);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return bookService.deleteBook(id);
    }


    @PostMapping(value = "/create")
    public BookDto create(@RequestBody BookDto book) {
        book.setId(book.getId());
        bookService.addBook(book);
        return book;
    }

    /*@PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<Bookdto> list) {
        for (Bookdto book : list) {
            book.setId(book.getId());
            bookService.addBook(book);
        }
        return true;
    }*/

   /* @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody Bookdto bookdto) {
        for (Bookdto dto : bookdtoList) {
            if (dto.getId().equals(id)) {
                dto.setName(studentDTO.getName());
                dto.setSurname(studentDTO.getSurname());
                return true;
            }
        }
        return false;
    }*/
}
