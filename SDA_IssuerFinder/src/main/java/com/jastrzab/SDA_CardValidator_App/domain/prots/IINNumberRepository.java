package com.jastrzab.SDA_CardValidator_App.domain.prots;

import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.IINNumber;
import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IINNumberRepository extends JpaRepository<IINNumber,Long> {
}
