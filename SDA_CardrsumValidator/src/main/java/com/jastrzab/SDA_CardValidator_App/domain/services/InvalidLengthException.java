package com.jastrzab.SDA_CardValidator_App.domain.services;

public class InvalidLengthException extends RuntimeException
{
    public InvalidLengthException(String message) {
        super(message);
    }
}
