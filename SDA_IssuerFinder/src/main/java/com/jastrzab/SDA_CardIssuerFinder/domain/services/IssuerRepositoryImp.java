package com.jastrzab.SDA_CardIssuerFinder.domain.services;

import com.jastrzab.SDA_CardIssuerFinder.domain.model.Entity.Issuer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class IssuerRepositoryImp {

    @PersistenceContext
    EntityManager em = null;

    @Transactional
    public Issuer findByIIN(List<String> iinList){
        String query = "SELECT i FROM Issuer i JOIN FETCH i.iinNumbers n WHERE n.iin in :iinList";

        return em.createQuery(query, Issuer.class)
                .setParameter("iinList",iinList)
                .getSingleResult();
    }
}
