package com.example.service;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public BookDto addBook(BookDto dto) {
        BookEntity entity = new BookEntity();
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPublishYear(dto.getPublishYear());
        entity.setAmount(dto.getAmount());

        bookRepository.save(entity);
        dto.setId(entity.getId());
        return dto;

    }

    public List<BookEntity> bookList() {
        List<BookEntity> bookList = bookRepository.bookList();
        if (bookList == null) {
            System.out.println("\n No book yet.");
        }
        for (BookEntity book : bookList) {
            System.out.println(book);
        }
        return bookList;
    }

    public Boolean deleteBook(Integer bookId) {
        BookEntity book = bookRepository.getId(bookId);
        if (book == null) {
            System.out.println("\n Not found book.");
            return null;
        }
        int n = bookRepository.deleteBook(bookId);
        if (n != 0) {
            System.out.println("\n Deleted book");
        }

        return null;
    }
}
