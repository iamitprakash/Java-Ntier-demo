package com.example.ntierdemo.viewmodels;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorPageViewModel {
    private final String entity;
    private final LocalDateTime transmitOn;
    private final List<DomainErrorViewModel> domainErrors;

    public ValidationErrorPageViewModel(String entity, LocalDateTime transmitOn, List<DomainErrorViewModel> domainErrors) {
        this.entity = entity;
        this.transmitOn = transmitOn;
        this.domainErrors = domainErrors;
    }

    public String getEntity() {
        return entity;
    }

    public LocalDateTime getTransmitOn() {
        return transmitOn;
    }

    public List<DomainErrorViewModel> getDomainErrors() {
        return domainErrors;
    }
}
