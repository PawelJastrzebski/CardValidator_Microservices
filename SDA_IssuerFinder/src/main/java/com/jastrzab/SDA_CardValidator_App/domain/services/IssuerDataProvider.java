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

        Issuer americanExpress = issuerRepository.save(new Issuer("American Express"));
        IINNumber iin34 = iinNumberRepository.save(new IINNumber("34"));
        IINNumber iin37 = iinNumberRepository.save(new IINNumber("37"));
        americanExpress.addIINNumer(iin34);
        americanExpress.addIINNumer(iin37);
        issuerRepository.save(americanExpress);



        Issuer bankcard = issuerRepository.save(new Issuer("Bankcard"));
        IINNumber iin5610 = iinNumberRepository.save(new IINNumber("5610"));
        IINNumber iin560221 = iinNumberRepository.save(new IINNumber("560221"));
        IINNumber iin560222 = iinNumberRepository.save(new IINNumber("560222"));
        IINNumber iin560223 = iinNumberRepository.save(new IINNumber("560223"));
        IINNumber iin560224 = iinNumberRepository.save(new IINNumber("560224"));
        IINNumber iin560225 = iinNumberRepository.save(new IINNumber("560225"));
        bankcard.addIINNumer(iin5610);
        bankcard.addIINNumer(iin560221);
        bankcard.addIINNumer(iin560222);
        bankcard.addIINNumer(iin560223);
        bankcard.addIINNumer(iin560224);
        bankcard.addIINNumer(iin560225);
        issuerRepository.save(bankcard);


        Issuer chinaTUnion = issuerRepository.save(new Issuer("China T-Union"));
        IINNumber iin31 = iinNumberRepository.save(new IINNumber("31"));
        chinaTUnion.addIINNumer(iin31);
        issuerRepository.save(chinaTUnion);

        Issuer chinaUnionPay = issuerRepository.save(new Issuer("China UnionPay"));
        IINNumber iin62 = iinNumberRepository.save(new IINNumber("62"));
        chinaTUnion.addIINNumer(iin62);
        issuerRepository.save(chinaUnionPay);


        Issuer dinersClubenRoute = issuerRepository.save(new Issuer("China UnionPay"));
        IINNumber iin2014 = iinNumberRepository.save(new IINNumber("2014"));
        IINNumber iin2149 = iinNumberRepository.save(new IINNumber("2149"));
        dinersClubenRoute.addIINNumer(iin2014);
        dinersClubenRoute.addIINNumer(iin2149);
        issuerRepository.save(dinersClubenRoute);



        Issuer dinersClubInternational = issuerRepository.save(new Issuer("Diners Club International"));
        IINNumber iin36 = iinNumberRepository.save(new IINNumber("36"));
        IINNumber iin300 = iinNumberRepository.save(new IINNumber("300"));
        IINNumber iin301 = iinNumberRepository.save(new IINNumber("301"));
        IINNumber iin302 = iinNumberRepository.save(new IINNumber("302"));
        IINNumber iin303 = iinNumberRepository.save(new IINNumber("303"));
        IINNumber iin304 = iinNumberRepository.save(new IINNumber("304"));
        IINNumber iin305 = iinNumberRepository.save(new IINNumber("305"));
        IINNumber iin3095 = iinNumberRepository.save(new IINNumber("3095"));
        IINNumber iin38 = iinNumberRepository.save(new IINNumber("38"));
        IINNumber iin39 = iinNumberRepository.save(new IINNumber("39"));
        dinersClubInternational.addIINNumer(iin36);
        dinersClubInternational.addIINNumer(iin300);
        dinersClubInternational.addIINNumer(iin301);
        dinersClubInternational.addIINNumer(iin302);
        dinersClubInternational.addIINNumer(iin303);
        dinersClubInternational.addIINNumer(iin304);
        dinersClubInternational.addIINNumer(iin305);
        dinersClubInternational.addIINNumer(iin3095);
        dinersClubInternational.addIINNumer(iin38);
        dinersClubInternational.addIINNumer(iin39);
        issuerRepository.save(dinersClubInternational);



    }

}
