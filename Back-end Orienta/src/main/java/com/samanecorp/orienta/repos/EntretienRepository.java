package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienRepository  extends JpaRepository<Entretien, Integer> {

    //recupere le nombre d'entretiens
    @Query("select count(id) from Entretien")
    public int CountEntretien();
}
