package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.TopUniversite;
import com.samanecorp.orienta.repos.TopUniversiteRepository;
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
public class TopUniversiteController {

    @Autowired
    private TopUniversiteRepository topUniversiteRepository;

    /**
     * Ajouter un top universite
     * @param topUniversite
     * @return
     */
    @PostMapping("/TopUniversites")
    public TopUniversite saveTopUniversite(@Valid @RequestBody TopUniversite topUniversite)
    {
        return topUniversiteRepository.save(topUniversite);
    }

    /**
     * Get all top universités
     * @return
     */
    @GetMapping("/TopUniversites")
    public List<TopUniversite> getAllTopUniversites() {
        return topUniversiteRepository.findAll();
    }

    /**
     * Get top universite by Id
     * @param topuniversiteId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/TopUniversites/{id}")
    public ResponseEntity<TopUniversite> getTopUniversiteById(@PathVariable(value = "id") int topuniversiteId) throws ResourceNotFoundException {
        TopUniversite topUniversite = topUniversiteRepository.findById(topuniversiteId)
                .orElseThrow(() -> new ResourceNotFoundException("Top Universite not found for this id :: " + topuniversiteId));
        return ResponseEntity.ok().body(topUniversite);
    }

    /**
     * Update les informations d'un top universite
     * @param topuniversiteId
     * @param topUniversiteDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/TopUniversites/{id}")
    public ResponseEntity<TopUniversite> updateTopUniversite(@PathVariable(value = "id") int topuniversiteId, @Valid @RequestBody TopUniversite topUniversiteDetails) throws ResourceNotFoundException {
        TopUniversite topUniversite = topUniversiteRepository.findById(topuniversiteId)
                .orElseThrow(() -> new ResourceNotFoundException("Top Universite not found for this id :: " + topuniversiteId));

        final TopUniversite updatedTopUniversite = topUniversiteRepository.saveAndFlush(topUniversiteDetails);
        return ResponseEntity.ok(updatedTopUniversite);
    }

    /**
     * Delete un top universite
     * @param topuniversiteId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/TopUniversites/{id}")
    public Map<String, Boolean> deleteTopUniversite(@PathVariable(value = "id") int topuniversiteId) throws ResourceNotFoundException {
        TopUniversite topUniversite = topUniversiteRepository.findById(topuniversiteId)
                .orElseThrow(() -> new ResourceNotFoundException("Top universite not found for this id :: " + topuniversiteId));

        topUniversiteRepository.delete(topUniversite);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
