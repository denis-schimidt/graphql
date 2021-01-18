package com.schimidt.graphql.dto;

import com.schimidt.graphql.domain.model.Book;
import com.schimidt.graphql.domain.model.Review;

public class ReviewDto {
    private Long id;
    private Integer stars;
    private String commentary;
    private Long bookId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Review toModel(Book book) {
        Review review = new Review();

        review.setId(id);
        review.setCommentary(commentary);
        review.setStars(stars);
        review.setBook(book);

        return review;
    }
}
