package com.samanecorp.orienta.controller;


import com.samanecorp.orienta.entities.Demande;
import com.samanecorp.orienta.entities.DomaineFormation;
import com.samanecorp.orienta.entities.Formation;
import com.samanecorp.orienta.repos.DemandeRepository;
import com.samanecorp.orienta.repos.DomaineFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class DomaineFormationController {

    @Autowired
    private DomaineFormationRepository domaineFormationRepository;

    /**
     * Get all domaines formations
     * @return
     */
    @GetMapping("/domaineFormations")
    public List<DomaineFormation> getAllDomaineFormations() {
        return domaineFormationRepository.findAll();
    }

    /**
     * Get domaine formation By Id
     * @param domaineFormationId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/domaineFormations/{id}")
    public ResponseEntity<DomaineFormation> getDomaineFormationById(@PathVariable(value = "id") int domaineFormationId)
            throws ResourceNotFoundException {
        DomaineFormation domaineFormation = domaineFormationRepository.findById(domaineFormationId)
                .orElseThrow(() -> new ResourceNotFoundException("Domaine Formation not found for this id :: " + domaineFormationId));
        return ResponseEntity.ok().body(domaineFormation);
    }

    /**
     * Add un domaine formation
     * @param domaineFormation
     * @return
     */
    @PostMapping("/domaineFormations")
    public DomaineFormation createDomaineFormation(@Valid @RequestBody DomaineFormation domaineFormation) {
        return domaineFormationRepository.save(domaineFormation);
    }

    /**
     * Update un domaine formation
     * @param domaineFormationId
     * @param domaineFormationDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/domaineFormations/{id}")
    public ResponseEntity<DomaineFormation> updateDomaineFormation(@PathVariable(value = "id") int domaineFormationId,
                                                  @Valid @RequestBody DomaineFormation domaineFormationDetails) throws ResourceNotFoundException {
        DomaineFormation domaineFormation = domaineFormationRepository.findById(domaineFormationId)
                .orElseThrow(() -> new ResourceNotFoundException("Domaine Formation not found for this id :: " + domaineFormationId));

        final DomaineFormation updatedDomaineFormation = domaineFormationRepository.saveAndFlush(domaineFormationDetails);
        return ResponseEntity.ok(updatedDomaineFormation);
    }

    /**
     * Delete un domaine formation
     * @param domaineFormationId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/domaineFormations/{id}")
    public Map<String, Boolean> deleteDomaineFormation(@PathVariable(value = "id") int domaineFormationId)
            throws ResourceNotFoundException {
        DomaineFormation domaineFormation = domaineFormationRepository.findById(domaineFormationId)
                .orElseThrow(() -> new ResourceNotFoundException("Domaine Formation not found for this id :: " + domaineFormationId));

        domaineFormationRepository.delete(domaineFormation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get all domaines formation d'une université en fonction de son email
     * @param email
     * @return
     */
    @GetMapping("/domaineFormations/universite/{email}")
    public List<DomaineFormation> getDomaineUni(@PathVariable("email") String email) {
        List<DomaineFormation> domaineFormations = domaineFormationRepository.getDomainesFormationsUniversite(email);
        return domaineFormations;
    }

}
