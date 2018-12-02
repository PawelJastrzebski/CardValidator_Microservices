package com.jastrzab.SDA_CardValidator_App.api;


import com.jastrzab.SDA_CardValidator_App.domain.model.ChecksumServiceResponse;
import com.jastrzab.SDA_CardValidator_App.domain.services.InvalidDigitsSequence;
import com.jastrzab.SDA_CardValidator_App.domain.services.InvalidLengthException;
import com.jastrzab.SDA_CardValidator_App.domain.services.LuhnCardValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checksum")
public class CardsumValidatorController {

    private LuhnCardValidatorService luhnCardValidatorService;

    @Autowired
    public CardsumValidatorController(LuhnCardValidatorService luhnCardValidatorService) {
        this.luhnCardValidatorService = luhnCardValidatorService;
    }

    @GetMapping("{number}")
    public ResponseEntity<ChecksumServiceResponse> checksum(@PathVariable("number") String cardNumber) {
        ChecksumServiceResponse checksumServiceResponse = new ChecksumServiceResponse();
        try{
        luhnCardValidatorService.validate(cardNumber);
            checksumServiceResponse.setIsCorrect(true);
        }catch (InvalidLengthException |InvalidDigitsSequence e){
            checksumServiceResponse.setIsCorrect(false);
            checksumServiceResponse.setErrorReason(e.getMessage());
        }
        return new ResponseEntity<>(checksumServiceResponse, HttpStatus.OK);
    }
}
