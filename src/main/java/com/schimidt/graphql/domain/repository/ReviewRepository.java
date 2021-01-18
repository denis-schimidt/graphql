package com.schimidt.graphql.domain.repository;

import com.schimidt.graphql.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {}
