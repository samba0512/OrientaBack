package com.samanecorp.orienta.controller;


import com.samanecorp.orienta.entities.*;
import com.samanecorp.orienta.repos.EtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class EtatDossierController {

    @Autowired
    EtatRepository etatRepository;

    /**
     * Get all etats dossiers
     * @return
     */
    @GetMapping("/etatDossier")
    public List<EtatDossier> getAllDemandes() {
        return etatRepository.findAll();
    }

    /**
     * get etat dossier by Id
     * @param EtatId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/etatDossier/{id}")
    public ResponseEntity<EtatDossier> getEtatDossierById(@PathVariable(value = "id") int EtatId)
            throws ResourceNotFoundException {
        EtatDossier etatDossier = etatRepository.findById(EtatId)
                .orElseThrow(() -> new ResourceNotFoundException("Etat Dossier not found for this id :: " + EtatId));
        return ResponseEntity.ok().body(etatDossier);
    }

    /**
     * get etat by Id
     * @param etatId
     * @return
     */
    @GetMapping("/etatDossier/ByIdEtat/{id}")
    public EtatDossier getEtatId(@PathVariable(value = "id") int etatId)  {
        return etatRepository.getEtatDossierById(etatId);
    }

    /**
     * Add un etat dossier
     * @param etatDossier
     * @return
     */
    @PostMapping("/etatDossier")
    public EtatDossier createEtatDossier(@Valid @RequestBody EtatDossier etatDossier) {
        return etatRepository.save(etatDossier);
    }

    /**
     * Update un etat dossier
     * @param EtatId
     * @param EtatDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/etatDossier/{id}")
    public ResponseEntity<EtatDossier> updateEtatDossier( @PathVariable(value = "id") int EtatId,
                                                  @Valid @RequestBody EtatDossier EtatDetails) throws ResourceNotFoundException {
        EtatDossier etatDossier = etatRepository.findById(EtatId)
                .orElseThrow(() -> new ResourceNotFoundException("Etat Dossier not found for this id :: " + EtatId));

        final EtatDossier updatedEtat = etatRepository.saveAndFlush(EtatDetails);
        return ResponseEntity.ok(updatedEtat);
    }

    /**
     * Delete un etat dossier
     * @param EtatId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/etatDossier/{id}")
    public Map<String, Boolean> deleteEtatDossier(@PathVariable(value = "id") int EtatId)
            throws ResourceNotFoundException {
        EtatDossier etatDossier = etatRepository.findById(EtatId)
                .orElseThrow(() -> new ResourceNotFoundException("Etat Dossier not found for this id :: " + EtatId));

        etatRepository.delete(etatDossier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
