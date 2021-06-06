package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Agent;
import com.samanecorp.orienta.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    @Query("SELECT a FROM Agent a , User u WHERE a.user.email = :email and u.id = a.user.id")
    public Agent findAgentByEmail(String email);
}
