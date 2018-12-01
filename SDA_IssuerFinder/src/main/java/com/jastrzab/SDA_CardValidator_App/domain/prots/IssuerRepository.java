package com.jastrzab.SDA_CardValidator_App.domain.prots;

import com.jastrzab.SDA_CardValidator_App.domain.model.Entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer, Long> {

    @PersistenceContext
    EntityManager em = null;

//    @Query("FROM Issuer i JOIN FETCH i.iinNumbers n WHERE n.iin in :iinList")
//    Issuer findByIIN(@Param("iinList") List<Integer> list);

    default Issuer findByIIN(List<String> iinList){
        String query = "SELECT i FROM Issuer i JOIN FETCH i.iinNumbers n WHERE n.iin in :iinList";

        return em.createQuery(query, Issuer.class)
                .setParameter("iinList",iinList)
                .getSingleResult();
    }
}
