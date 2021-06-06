package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.FichiersDossiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichiersDossiersRepository extends JpaRepository<FichiersDossiers, Integer> {

    @Query("select f from FichiersDossiers f where f.dossierEtudiant.id=:idDossier")
    public List<FichiersDossiers> getfichiersDossiers(@Param("idDossier") int id);
}
