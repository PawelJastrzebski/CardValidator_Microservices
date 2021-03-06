package com.jastrzab.SDA_CardValidator_App.domain.services;

import com.jastrzab.SDA_CardValidator_App.domain.model.IssuerServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardIssuerService {

    @Value("${issuer.finder.service.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String findIssuer(String cardNumber) {

        String url = serviceUrl + "/issuer/" + cardNumber;
        System.out.println(url);
        ResponseEntity<IssuerServiceResponse> responseEntity = restTemplate.getForEntity(url, IssuerServiceResponse.class);
        return responseEntity.getBody().getIssuerName();
    }
}
