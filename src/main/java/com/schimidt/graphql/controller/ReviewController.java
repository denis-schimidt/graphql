package com.schimidt.graphql.controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.schimidt.graphql.domain.model.Review;
import com.schimidt.graphql.domain.service.ReviewService;
import com.schimidt.graphql.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private ReviewService reviewService;

    public Review createReview(ReviewDto reviewDto) {
        return reviewService.create(reviewDto);
    }
}
