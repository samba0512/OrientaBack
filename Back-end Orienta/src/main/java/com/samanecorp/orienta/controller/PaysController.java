package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Parcours;
import com.samanecorp.orienta.entities.Pays;
import com.samanecorp.orienta.repos.PaysRepository;
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
public class PaysController {

    @Autowired
    private PaysRepository paysRepository;

    /**
     * Get all countries
     * @return
     */
    @GetMapping("/pays")
    public List<Pays> getAllPays(){
        return paysRepository.getAllPays();
    }

    /**
     * get pays by Id
     * @param paysId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/pays/{id}")
    public ResponseEntity<Pays> getPaysById(@PathVariable(value = "id") int paysId)
            throws ResourceNotFoundException {
        Pays pays = paysRepository.findById(paysId)
                .orElseThrow(() -> new ResourceNotFoundException("Pays not found for this id :: " + paysId));
        return ResponseEntity.ok().body(pays);
    }

    /**
     * Add a country
     * @param pays
     * @return
     */
    @PostMapping("/pays")
    public Pays createPays(@Valid @RequestBody Pays pays) {
        return paysRepository.save(pays);
    }

    /**
     * Update les informations d'un pays
     * @param paysId
     * @param paysDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/pays/{id}")
    public ResponseEntity<Pays> updatePays(@PathVariable(value = "id") int paysId,
                                                   @Valid @RequestBody Pays paysDetails) throws ResourceNotFoundException {
        Pays pays = paysRepository.findById(paysId)
                .orElseThrow(() -> new ResourceNotFoundException("Pays not found for this id :: " + paysId));

        final Pays updatedpays = paysRepository.saveAndFlush(paysDetails);
        return ResponseEntity.ok(updatedpays);
    }

    /**
     * Delete a country
     * @param paysId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/pays/{id}")
    public Map<String, Boolean> deletePays(@PathVariable(value = "id") int paysId)
            throws ResourceNotFoundException {
        Pays pays = paysRepository.findById(paysId)
                .orElseThrow(() -> new ResourceNotFoundException("Pays not found for this id :: " + paysId));

        paysRepository.delete(pays);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
