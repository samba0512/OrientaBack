package com.samanecorp.orienta.security.services;

import com.samanecorp.orienta.entities.Role;
import com.samanecorp.orienta.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface AccountService {
    public User saveUser(@Valid @RequestBody User user);
//  public User findUserByUsername(String username);
    public User findUserByEmail(String email);

    public Role saveRole(@Valid @RequestBody Role role);
    public ResponseEntity<Role> findRoleByLibelle(String libelle);

    public void addRoleToUser(String username, String libelle);

}
