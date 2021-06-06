package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NiveauRepository extends JpaRepository<Niveau,Integer> {
}
