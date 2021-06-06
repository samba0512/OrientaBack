package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Formation;
import com.samanecorp.orienta.entities.TopUniversite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopUniversiteRepository extends JpaRepository<TopUniversite, Integer> {
    @Query("SELECT top FROM TopUniversite top , Universite u where top.universite.id = u.id")
    public List<Formation> getAllTopUniversites();
}
