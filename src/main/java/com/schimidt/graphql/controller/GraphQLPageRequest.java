package com.schimidt.graphql.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schimidt.graphql.exception.GraphQLValidationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

class GraphQLPageRequest implements Pageable {
    private final Pageable pageable;

    @JsonCreator
    public GraphQLPageRequest(@JsonProperty("page") int page, @JsonProperty("size") int size) {
        validate(page < 0, "The field page can NOT be less than 0 ", "page");
        validate(size > 50, "The field size can NOT be greater than 50 ", "size");

        pageable = PageRequest.of(page, size);
    }

    private void validate(boolean hasErrorInExpression, String errorMessage, String field) {

        if(hasErrorInExpression) {
            throw new GraphQLValidationException(errorMessage, field);
        }
    }

    @Override
    public int getPageNumber() {
        return pageable.getPageNumber();
    }

    @Override
    public int getPageSize() {
        return pageable.getPageSize();
    }

    @Override
    public long getOffset() {
        return pageable.getOffset();
    }

    @Override
    public Sort getSort() {
        return pageable.getSort();
    }

    @Override
    public Pageable next() {
        return pageable.next();
    }

    @Override
    public Pageable previousOrFirst() {
        return pageable.previousOrFirst();
    }

    @Override
    public Pageable first() {
        return pageable.first();
    }

    @Override
    public boolean hasPrevious() {
        return pageable.hasPrevious();
    }
}
