package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Entretien;
import com.samanecorp.orienta.repos.EntretienRepository;
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
public class EntretienController {

    @Autowired
    private EntretienRepository entretienRepository;

    /**
     * Get all entretiens
     * @return
     */
    @GetMapping("/entretiens")
    public List<Entretien> getAllEntretiens() {
        return entretienRepository.findAll();
    }

    /**
     * Get entretien by Id
     * @param entretienId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/entretiens/{id}")
    public ResponseEntity<Entretien> getEntretienById(@PathVariable(value = "id") int entretienId)
            throws ResourceNotFoundException {
        Entretien entretien = entretienRepository.findById(entretienId)
                .orElseThrow(() -> new ResourceNotFoundException("Entretien not found for this id :: " + entretienId));
        return ResponseEntity.ok().body(entretien);
    }

    /**
     * Add un entretien
     * @param entretien
     * @return
     */
    @PostMapping("/entretiens")
    public Entretien createEntretien(@Valid @RequestBody Entretien entretien) {
        return entretienRepository.save(entretien);
    }

    /**
     * Update un entretien
     * @param entretienId
     * @param entretienDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/entretiens/{id}")
    public ResponseEntity<Entretien> updateEntretien(@PathVariable(value = "id") int entretienId,
                                             @Valid @RequestBody Entretien entretienDetails) throws ResourceNotFoundException {
        Entretien entretien = entretienRepository.findById(entretienId)
                .orElseThrow(() -> new ResourceNotFoundException("Entretien not found for this id :: " + entretienId));

        final Entretien updatedEntretien = entretienRepository.saveAndFlush(entretienDetails);
        return ResponseEntity.ok(updatedEntretien);
    }

    /**
     * Delete un entretien
     * @param entretienId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/entretiens/{id}")
    public Map<String, Boolean> deleteEntretien(@PathVariable(value = "id") int entretienId)
            throws ResourceNotFoundException {
        Entretien entretien = entretienRepository.findById(entretienId)
                .orElseThrow(() -> new ResourceNotFoundException("Entretien not found for this id :: " + entretienId));

        entretienRepository.delete(entretien);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get le nombres total d'entretiens
     * @return
     */
    //fonction qui recupere le nombres de demandes
    @GetMapping("/entretiens/total")
    public int getNombresEntretien() {
        return entretienRepository.CountEntretien();
    }

}
