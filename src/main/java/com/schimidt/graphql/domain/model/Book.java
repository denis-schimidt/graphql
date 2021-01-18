package com.schimidt.graphql.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String isbn = UUID.randomUUID().toString();

    private String title;

    private String subject;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

    private LocalDate createdAt = LocalDate.now();

    @Column(name = "is_active")
    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
