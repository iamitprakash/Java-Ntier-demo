package com.example.ntierdemo.viewmodels;

public class DomainErrorViewModel {
    private final String field;
    private final String errorMessage;

    public DomainErrorViewModel(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
