package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Role;
import com.samanecorp.orienta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findRoleByLibelle(String libelle);
}
