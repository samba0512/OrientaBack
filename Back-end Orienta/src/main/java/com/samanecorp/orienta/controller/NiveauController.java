package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Demande;
import com.samanecorp.orienta.entities.Niveau;
import com.samanecorp.orienta.repos.NiveauRepository;
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
public class NiveauController {

    @Autowired
    private NiveauRepository niveauRepository;

    /**
     * Add un niveau
     * @param niveau
     * @return
     */
    @PostMapping("/niveaux")
    public Niveau insertNiveau(@Valid Niveau niveau){
        return niveauRepository.save(niveau);
    }

    /**
     * Delete un niveau
     * @param niveauId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/niveaux/{id}")
    public Map<String, Boolean> deleteNiveau(@PathVariable(value = "id") int niveauId)
            throws ResourceNotFoundException {
        Niveau niveau = niveauRepository.findById(niveauId)
                .orElseThrow(() -> new ResourceNotFoundException("Niveau not found for this id :: " + niveauId));

        niveauRepository.delete(niveau);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * update on niveau instance
     * @param niveauDetails
     * @param niveauId
     * @return
     * @throws ResourceNotFoundException
     */

    @PutMapping("/niveaux/{id}")
    public ResponseEntity<Niveau> updateNiveau(@PathVariable(value = "id") int niveauId,
                                                 @Valid @RequestBody Niveau niveauDetails) throws ResourceNotFoundException {
        Niveau niveau = niveauRepository.findById(niveauId)
                .orElseThrow(() -> new ResourceNotFoundException("Niveau not found for this id :: " + niveauId));

        final Niveau niveau_final = niveauRepository.saveAndFlush(niveauDetails);
        return ResponseEntity.ok(niveau_final);
    }

    /**
     * get all niveaux
     * @return
     */
    @GetMapping("/niveaux")
    public List<Niveau> getAllNiveau(){
        return niveauRepository.findAll();
    }

    /**
     * Get Niveau by Id
     * @param niveauId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/niveaux/{id}")
    public ResponseEntity<Niveau> getNiveauById(@PathVariable(value = "id") int niveauId)
            throws ResourceNotFoundException {
        Niveau niveau = niveauRepository.findById(niveauId)
                .orElseThrow(() -> new ResourceNotFoundException("Niveau not found for this id :: " + niveauId));
        return ResponseEntity.ok().body(niveau);
    }

}
