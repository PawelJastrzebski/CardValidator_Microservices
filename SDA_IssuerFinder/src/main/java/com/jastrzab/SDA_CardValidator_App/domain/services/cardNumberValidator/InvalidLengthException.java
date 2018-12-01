package com.jastrzab.SDA_CardValidator_App.domain.services.cardNumberValidator;

public class InvalidLengthException extends RuntimeException {

    public InvalidLengthException(String message) {
        super(message);
    }
}
