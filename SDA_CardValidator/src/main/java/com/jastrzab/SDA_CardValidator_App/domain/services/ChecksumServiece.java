package com.jastrzab.SDA_CardValidator_App.domain.services;

import com.jastrzab.SDA_CardValidator_App.domain.model.ChecksumServiceResponse;
import com.jastrzab.SDA_CardValidator_App.domain.model.IssuerServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChecksumServiece {
    @Value("${isCheck.service.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;
    public boolean isChecksumCorrect(String cardNumber) {
            ResponseEntity<ChecksumServiceResponse> responseEntity = restTemplate.getForEntity(serviceUrl + "/checksum/", ChecksumServiceResponse.class);
            return responseEntity.getBody().getIsCorrect();
    }
}
