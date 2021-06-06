package com.samanecorp.orienta.repos;


import com.samanecorp.orienta.entities.EtatDossier;
import com.samanecorp.orienta.entities.Pays;
import com.samanecorp.orienta.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PaysRepository extends JpaRepository<Pays, Integer> {

    @Query("SELECT p FROM Pays p")
    public List<Pays> getAllPays();
}
