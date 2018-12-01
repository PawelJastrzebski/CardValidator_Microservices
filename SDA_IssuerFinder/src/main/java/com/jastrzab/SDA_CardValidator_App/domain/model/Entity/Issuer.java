package com.jastrzab.SDA_CardValidator_App.domain.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Issuer extends BaseEntity {
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<IINNumber> iinNumbers = new HashSet<>();

    public Issuer(String name) {
        this.name = name;
    }

    public void addIINNumer(IINNumber iinNumber){
        this.iinNumbers.add(iinNumber);
        iinNumber.setOwner(this);
    }
}
