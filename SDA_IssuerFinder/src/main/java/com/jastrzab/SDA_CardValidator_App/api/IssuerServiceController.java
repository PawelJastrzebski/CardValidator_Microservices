package com.jastrzab.SDA_CardValidator_App.api;

import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.Issuer;
import com.jastrzab.SDA_CardValidator_App.domain.model.IssuerServiceResponse;
import com.jastrzab.SDA_CardValidator_App.domain.prots.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("issuer")
public class IssuerServiceController {

    private IssuerRepository issuerRepository;

    @Autowired
    public IssuerServiceController(IssuerRepository issuerRepository) {
        this.issuerRepository = issuerRepository;
    }

    @GetMapping("{number}")
    public ResponseEntity<IssuerServiceResponse> getIssuer(@PathVariable("number") String cardNumber){

        List<String> iinList = this.generatePossibleIINList(cardNumber);
        Issuer issuer = issuerRepository.findByIIN(iinList);
        IssuerServiceResponse issuerServiceResponse = new IssuerServiceResponse(issuer.getName());

        return new ResponseEntity<>(issuerServiceResponse, HttpStatus.OK);
    }

    private List<String> generatePossibleIINList(String cardNumber){
        List<String> strings = new ArrayList<>();
        for (Integer i = 1 ; i <10 ; i++){
            String substring = cardNumber.substring(0, i);
            strings.add(substring);
        }
        return strings;
    }
}
