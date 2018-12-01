package com.jastrzab.SDA_CardIssuerFinder.domain.services.cardNumberValidator;

public class InvalidLengthException extends RuntimeException {

    public InvalidLengthException(String message) {
        super(message);
    }
}
