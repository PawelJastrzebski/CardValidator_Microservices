package com.jastrzab.SDA_CardValidator_App.domain.services;

import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.IINNumber;
import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.Issuer;
import com.jastrzab.SDA_CardValidator_App.domain.prots.IINNumberRepository;
import com.jastrzab.SDA_CardValidator_App.domain.prots.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class IssuerDataProvider {

    @Autowired
    IssuerRepository issuerRepository;

    @Autowired
    IINNumberRepository iinNumberRepository;

    @PostConstruct
    public void init(){

        Issuer visa = issuerRepository.save(new Issuer("Visa"));
        IINNumber iin = iinNumberRepository.save(new IINNumber("4"));
        visa.addIINNumer(iin);
        issuerRepository.save(visa);


    }

}
