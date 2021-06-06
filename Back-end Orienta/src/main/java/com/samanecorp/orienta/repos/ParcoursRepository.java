package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Parcours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, Integer> {

    @Query("SELECT p From Parcours p, Etudiant e WHERE p.etudiant_id = e.id AND e.id=:idEtudiant")
    public List<Parcours> getParcoursByEtudiantId(@Param("idEtudiant") int id);
}
