package com.schimidt.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQLValidationException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public GraphQLValidationException(String message, String invalidField) {
        super(message);
        extensions.put("invalidField", invalidField);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return this.extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
