package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Role;
import com.samanecorp.orienta.repos.RoleRepository;
import com.samanecorp.orienta.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class RoleController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Ajouter un role
     * @param role
     * @return
     */
    @PostMapping("/roles")
    public Role saveRole(@Valid @RequestBody Role role)
    {
        return roleRepository.save(role);
    }

    /**
     * get all roles
     * @return
     */
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Get role by Id
     * @param roleId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") int roleId) throws ResourceNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));
        return ResponseEntity.ok().body(role);
    }

    /**
     * Update les informations d'un role
     * @param roleId
     * @param RoleDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") int roleId, @Valid @RequestBody Role RoleDetails) throws ResourceNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));

        final Role updatedRole = roleRepository.saveAndFlush(RoleDetails);
        return ResponseEntity.ok(updatedRole);
    }

    /**
     * Delete un role
     * @param roleId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/roles/{id}")
    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") int roleId) throws ResourceNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));

        roleRepository.delete(role);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
