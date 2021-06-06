package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.EtatDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EtatRepository extends JpaRepository<EtatDossier, Integer> {

    @Query("select d from EtatDossier d where d.id=:id")
    public EtatDossier getEtatDossierById(@Param("id") int id);

}
