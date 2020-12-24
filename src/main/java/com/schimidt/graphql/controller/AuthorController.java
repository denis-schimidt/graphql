package com.schimidt.graphql.controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.schimidt.graphql.domain.model.Author;
import com.schimidt.graphql.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private AuthorService authorService;

    public Optional<Author> findAuthor(String email){
        return authorService.findAuthorByEmail(email);
    }

    public Author createAuthor(Author author) {
        return authorService.create(author);
    }
}
