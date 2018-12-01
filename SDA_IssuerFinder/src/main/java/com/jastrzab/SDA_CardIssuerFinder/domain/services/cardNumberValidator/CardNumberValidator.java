package com.jastrzab.SDA_CardIssuerFinder.domain.services.cardNumberValidator;

import org.springframework.stereotype.Service;

@Service
public class CardNumberValidator {

    public void validate(String cardNumber){
        if (cardNumber.length() < 12){
            throw new InvalidLengthException("Credit card number must have at least 12 digits");
        }
    }

}
