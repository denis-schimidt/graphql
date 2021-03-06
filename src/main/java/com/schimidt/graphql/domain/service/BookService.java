package com.schimidt.graphql.domain.service;

import com.schimidt.graphql.domain.model.Book;
import com.schimidt.graphql.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public Book create(Book book, String email) {
        book.setAuthor(authorService.findAuthorByEmail(email).get());
        return bookRepository.save(book);
    }

    public Optional<Book> findBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Page<Book> listAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
