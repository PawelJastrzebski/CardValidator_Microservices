package com.jastrzab.SDA_CardIssuerFinder.domain.services;

public class IssuerNotFoundException extends RuntimeException {
    public IssuerNotFoundException(String message) {
        super(message);
    }
}
