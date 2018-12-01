package com.jastrzab.SDA_CardIssuerFinder.domain.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @Column(unique = true)
    private Set<IINNumber> iinNumbers = new HashSet<>();

    public Issuer(String name) {
        this.name = name;
    }

    public void addIINNumer(IINNumber iinNumber){
        this.iinNumbers.add(iinNumber);
        iinNumber.setOwner(this);
    }
}
