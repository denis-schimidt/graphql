package com.schimidt.graphql.controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.schimidt.graphql.domain.model.Book;
import com.schimidt.graphql.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public Optional<Book> findBook(String isbn) {
        return bookService.findBook(isbn);
    }

    public Book createBook(Book book, String email) {
        return bookService.create(book, email);
    }
}


