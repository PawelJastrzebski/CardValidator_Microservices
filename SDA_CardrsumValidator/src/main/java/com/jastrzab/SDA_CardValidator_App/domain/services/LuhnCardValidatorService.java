package com.jastrzab.SDA_CardValidator_App.domain.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LuhnCardValidatorService {

    public void validate(String cardNumber) {
        if (cardNumber.length() < 12) {
            throw new InvalidLengthException("card number must have at least 12 digits");
        }

        Integer[] digits = toDigitArray(cardNumber);
        int first = digits.length - 1;
        for (int i = first - 1; i > 0; i--) {
            digits[first] += (digits[i] > 4) ? digits[i] * 2 - 9 : digits[i]*2;
            digits[first] += digits[--i];
        }

        if (digits[first] % 10 != 0){
            throw new InvalidDigitsSequence("Number is invalid");
        }

    }

    public Integer[] toDigitArray(String cardNumber) {
        if (cardNumber.length() % 2 == 0){
            cardNumber = "0"+cardNumber;
        }
        Integer[] integers = new Integer[cardNumber.length()];
        for (int i = 0; i < cardNumber.length(); i++) {
            String substring = cardNumber.substring(i, i + 1);
            integers[i] = Integer.valueOf(substring);
        }
        return integers;
    }
}
