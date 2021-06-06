package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Paiement;
import com.samanecorp.orienta.repos.PaiementRepository;
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
public class PaiementController {

    @Autowired
    private PaiementRepository paiementRepository;

    /**
     * get all paiements
     * @return
     */
    @GetMapping("/paiements")
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    /**
     * get paiement by Id
     * @param paiementId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/paiements/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable(value = "id") int paiementId)
            throws ResourceNotFoundException {
        Paiement paiement = paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement not found for this id :: " + paiementId));
        return ResponseEntity.ok().body(paiement);
    }

    /**
     * Add un paiement
     * @param paiement
     * @return
     */
    @PostMapping("/paiements")
    public Paiement createPaiement(@Valid @RequestBody Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    /**
     * Update un paiement
     * @param paiementId
     * @param PaiementDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/paiements/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable(value = "id") int paiementId,
                                                 @Valid @RequestBody Paiement PaiementDetails) throws ResourceNotFoundException {
        Paiement paiement = paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement not found for this id :: " + paiementId));

        final Paiement updatedPaiement = paiementRepository.saveAndFlush(PaiementDetails);
        return ResponseEntity.ok(updatedPaiement);
    }

    /**
     * Delete un paiement
     * @param paiementId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/paiements/{id}")
    public Map<String, Boolean> deletePaiement(@PathVariable(value = "id") int paiementId)
            throws ResourceNotFoundException {
        Paiement paiement = paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement not found for this id :: " + paiementId));

        paiementRepository.delete(paiement);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
