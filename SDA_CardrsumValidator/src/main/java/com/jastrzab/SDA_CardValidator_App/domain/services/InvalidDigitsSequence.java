package com.jastrzab.SDA_CardValidator_App.domain.services;

public class InvalidDigitsSequence extends RuntimeException {
    public InvalidDigitsSequence(String message) {
        super(message);
    }
}
