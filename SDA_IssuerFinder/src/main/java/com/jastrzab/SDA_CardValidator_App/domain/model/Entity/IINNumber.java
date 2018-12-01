package com.jastrzab.SDA_CardValidator_App.domain.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IINNumber extends BaseEntity {
    private String iin;
    @JoinColumn(name = "idIssuer")
    @ManyToOne
    private Issuer owner;

    public IINNumber(String iin) {
        this.iin = iin;
    }

    public void setOwner(Issuer issuer){
        this.owner = issuer;
        issuer.getIinNumbers().add(this);
    }

    public void setIin(String iin) {
        this.iin = iin;
    }
}
