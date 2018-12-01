package com.jastrzab.SDA_CardIssuerFinder.domain.services;

import com.jastrzab.SDA_CardIssuerFinder.domain.model.Entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer, Long> {
}
