package com.jastrzab.SDA_CardIssuerFinder.domain.services;

import com.jastrzab.SDA_CardIssuerFinder.domain.model.Entity.IINNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IINNumberRepository extends JpaRepository<IINNumber,Long> {
}
