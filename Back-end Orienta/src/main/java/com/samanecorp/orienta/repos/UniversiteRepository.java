package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Agent;
import com.samanecorp.orienta.entities.Formation;
import com.samanecorp.orienta.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Integer> {

    //recupere les informations de l'universite en fonction de son email
    @Query("SELECT e FROM Universite e , User u WHERE e.user.email = :email and u.id = e.user.id")
    public Universite findUniversiteByEmail(String email);

    //recupere le nombre d'universites
    @Query("select count(id) from Universite")
    public int CountUniversite();

    /**
     * get university by name
     * @param nom
     * @return
     */
    @Query("SELECT u FROM Universite u where u.nom = :nom ")
    public Universite getUNiversityByNom(String nom);
}
