package com.schimidt.graphql.domain.service;

import com.schimidt.graphql.domain.model.Review;
import com.schimidt.graphql.domain.repository.BookRepository;
import com.schimidt.graphql.domain.repository.ReviewRepository;
import com.schimidt.graphql.dto.ReviewDto;
import com.schimidt.graphql.exception.GraphQLValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private BookRepository bookRepository;

    @Autowired
    ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Review create(ReviewDto reviewDto) {
        return bookRepository.findById(reviewDto.getBookId())
                .map(book -> reviewRepository.save(reviewDto.toModel(book)))
                .orElseThrow(() -> new GraphQLValidationException("This book (id: " + reviewDto.getBookId() + ") does NOT exist", "bookId"));
    }
}
