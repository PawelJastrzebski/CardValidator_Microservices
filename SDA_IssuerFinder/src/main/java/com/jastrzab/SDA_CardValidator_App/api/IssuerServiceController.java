package com.jastrzab.SDA_CardValidator_App.api;

import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.Issuer;
import com.jastrzab.SDA_CardValidator_App.domain.model.IssuerServiceResponse;
import com.jastrzab.SDA_CardValidator_App.domain.model.WebError;
import com.jastrzab.SDA_CardValidator_App.domain.services.IssuerRepositoryImp;
import com.jastrzab.SDA_CardValidator_App.domain.services.cardNumberValidator.CardNumberValidator;
import com.jastrzab.SDA_CardValidator_App.domain.services.cardNumberValidator.InvalidLengthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("issuer")
public class IssuerServiceController {

    private IssuerRepositoryImp issuerRepository;
    private CardNumberValidator cardNumberValidator;

    @Autowired
    public IssuerServiceController(IssuerRepositoryImp issuerRepository, CardNumberValidator cardNumberValidator) {
        this.issuerRepository = issuerRepository;
        this.cardNumberValidator = cardNumberValidator;
    }

    @GetMapping("{number}")
    public ResponseEntity<IssuerServiceResponse> getIssuer(@PathVariable("number") String cardNumber){

        cardNumberValidator.validate(cardNumber);
        List<String> iinList = this.generatePossibleIINList(cardNumber);
        Issuer issuer = issuerRepository.findByIIN(iinList);
        IssuerServiceResponse issuerServiceResponse = new IssuerServiceResponse(issuer.getName());

        return new ResponseEntity<>(issuerServiceResponse, HttpStatus.OK);
    }

    private List<String> generatePossibleIINList(String cardNumber){
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <10 ; i++){
            String substring = cardNumber.substring(0, i);
            strings.add(substring);
        }
        return strings;
    }

    @ExceptionHandler(InvalidLengthException.class)
    private ResponseEntity<WebError> error(InvalidLengthException e){
        WebError webError = new WebError(e.getMessage());
        return new ResponseEntity<>(webError,HttpStatus.BAD_REQUEST);
    }
}
