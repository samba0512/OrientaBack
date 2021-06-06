package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Niveau;
import com.samanecorp.orienta.entities.TypeFormations;
import com.samanecorp.orienta.repos.TypeFormationsRepository;
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
public class TypeFormationsController {

    @Autowired
    private TypeFormationsRepository typeFormationsRepository;

    /**
     * get all type formations
     * @return
     */
    @GetMapping("/typeFormations")
    public List<TypeFormations> getAllTypeFormations(){
        return typeFormationsRepository.findAll();
    }

    /**
     * Insert un type Formation
     * @param typeFormations
     * @return
     */
    @PostMapping("/typeFormations")
    public TypeFormations insertTypeFormations(@Valid TypeFormations typeFormations){
        return typeFormationsRepository.save(typeFormations);
    }

    /**
     * Delete un type formation
     * @param typeFormationId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/typeFormations/{id}")
    public Map<String, Boolean> deleteTypeFormation(@PathVariable(value = "id") int typeFormationId)
            throws ResourceNotFoundException {
        TypeFormations typeFormations = typeFormationsRepository.findById(typeFormationId)
                .orElseThrow(() -> new ResourceNotFoundException("Type formation not found for this id :: " + typeFormationId));

        typeFormationsRepository.delete(typeFormations);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Update les informations d'un type formation
     * @param typeFormationId
     * @param typeFormationDEtails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/typeFormations/{id}")
    public ResponseEntity<TypeFormations> updatePaiement(@PathVariable(value = "id") int typeFormationId,
                                                         @Valid @RequestBody TypeFormations typeFormationDEtails) throws ResourceNotFoundException {
        TypeFormations typeFormations = typeFormationsRepository.findById(typeFormationId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement not found for this id :: " + typeFormationId));

        final TypeFormations updatedTypeFormation = typeFormationsRepository.saveAndFlush(typeFormationDEtails);
        return ResponseEntity.ok(updatedTypeFormation);
    }

    /**
     * Get type formation By Id
     * @param TypeFormationId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/typeFormations/{id}")
    public ResponseEntity<TypeFormations> getNiveauById(@PathVariable(value = "id") int TypeFormationId)
            throws ResourceNotFoundException {
        TypeFormations typeFormations = typeFormationsRepository.findById(TypeFormationId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Formation not found for this id :: " + TypeFormationId));
        return ResponseEntity.ok().body(typeFormations);
    }

}
