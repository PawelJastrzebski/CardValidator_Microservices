package com.jastrzab.SDA_CardValidator_App.api;

import com.jastrzab.SDA_CardValidator_App.domain.model.AnalysisResponse;
import com.jastrzab.SDA_CardValidator_App.domain.services.CardIssuerService;
import com.jastrzab.SDA_CardValidator_App.domain.services.ChecksumServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DataServiceController {

    private ChecksumServiece checksumServiece;
    private CardIssuerService cardIssuerService;

    public DataServiceController() {
    }

    @Autowired
    public DataServiceController(ChecksumServiece checksumServiece, CardIssuerService cardIssuerService) {
        this.checksumServiece = checksumServiece;
        this.cardIssuerService = cardIssuerService;
    }

    @GetMapping("/card/{number}")
    public ResponseEntity<AnalysisResponse> getCardAnalysisData(@PathVariable String number){
        String issuer = cardIssuerService.findIssuer(number);
        boolean isCorrect = checksumServiece.isChecksumCorrect(number);

        return new ResponseEntity<>(new AnalysisResponse(issuer,isCorrect), HttpStatus.OK);

    }
}
