package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.DomaineFormation;
import com.samanecorp.orienta.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomaineFormationRepository extends JpaRepository<DomaineFormation, Integer> {

    /**
     Get domaine formation by university email
     @Param email
     */
    @Query("SELECT d FROM DomaineFormation d, Formation f WHERE f.domaineFormation.id = d.id and f.universite.user.email = :email GROUP BY f.domaineFormation.id")
    List<DomaineFormation> getDomainesFormationsUniversite(@Param("email") String email);
}
