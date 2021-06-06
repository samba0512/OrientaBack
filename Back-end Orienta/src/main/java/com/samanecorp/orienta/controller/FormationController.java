package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.DossierEtudiant;
import com.samanecorp.orienta.entities.Formation;
import com.samanecorp.orienta.repos.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class FormationController {

    @Autowired
    private FormationRepository formationRepository;

    /**
     * Get all formations
     * @return
     */
    @GetMapping("/formations")
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    /**
     * get formation By Id
     * @param formationId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/formations/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable(value = "id") int formationId)
            throws ResourceNotFoundException {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(() -> new ResourceNotFoundException("Formation not found for this id :: " + formationId));
        return ResponseEntity.ok().body(formation);
    }

    /**
     * Add une formation
     * @param formation
     * @return
     */
    @PostMapping("/formations")
    public Formation createFormation(@RequestBody Formation formation) {
        return formationRepository.save(formation);
    }

    /**
     * Update une formation
     * @param formationId
     * @param FormationDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/formations/{id}")
    public Formation updateFormation(@PathVariable(value = "id") int formationId,
                                                                  @Valid @RequestBody Formation FormationDetails) throws ResourceNotFoundException {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(() -> new ResourceNotFoundException("Formation not found for this id :: " + formationId));

         Formation updatedFormation = formationRepository.saveAndFlush(FormationDetails);
        return (updatedFormation);
    }

    /**
     * Delete une formation
     * @param formationId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/formations/{id}")
    public Map<String, Boolean> deleteFormation(@PathVariable(value = "id") int formationId)
            throws ResourceNotFoundException {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(() -> new ResourceNotFoundException("Formation not found for this id :: " + formationId));

        formationRepository.delete(formation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get all formations d'une université en fonction de son email
     * @param email
     * @return
     */
    @GetMapping("/formations/universite/{email}")
    public List<Formation> getFormaUni(@PathVariable("email") String email) {
        List<Formation> formation = formationRepository.getFormationsUniversite(email);
        return formation;
    }

    /**
     * get all the universities's formations
     * @return List of Formation
     */
    @GetMapping("/formations/universites")
    public List<Formation> getAllUniversiteFormation(){
        return formationRepository.getAllUniversiteFormation();
    }


    /**
     * Function to get all formations switch some params
     * @param formationNiveauId
     * @param formationTypeFormationId
     * @param formationUniversiteId
     * @return List of Formation
     */
    @GetMapping("/formations/niveau/{idNiveau}/typeFormation/{typeFormationId}/universite/{universiteId}")
    public ResponseEntity<List<Formation>> getFormationsByParams(@PathVariable("idNiveau") int formationNiveauId,
                                                                 @PathVariable("typeFormationId") int formationTypeFormationId,
                                                                 @PathVariable("universiteId") int formationUniversiteId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByParams(formationNiveauId,formationTypeFormationId,formationUniversiteId),
                HttpStatus.OK);
    }

    /**
     * get all formations by two params
     * @param formationNiveauId
     * @param formationTypeFormationId
     * @return List of Formations
     */
    @GetMapping("/formations/niveau/{idNiveau}/typeFormation/{typeFormationId}")
    public ResponseEntity<List<Formation>> getFormationsByParamsNiveauAndTypeFormation(@PathVariable("idNiveau") int formationNiveauId,
                                                                                       @PathVariable("typeFormationId") int formationTypeFormationId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByParamsNiveauAndTypeFormation(formationNiveauId,formationTypeFormationId),
                HttpStatus.OK
        );
    }

    /**
     * get all formations by two params
     * @param formationNiveauId
     * @param formationUniversiteId
     * @return List of formations
     */
    @GetMapping("/formations/niveau/{niveauId}/universite/{universiteId}")
    public ResponseEntity<List<Formation>> getFormationsByParamsNiveauIdAndUniversiteId(@PathVariable("niveauId") int formationNiveauId,
                                                                                        @PathVariable("universiteId") int formationUniversiteId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByParamsNiveauIdAndUniversiteId(formationNiveauId,formationUniversiteId),
                HttpStatus.OK);
    }

    /**
     * get all formations by two params
     * @param typeFormationNiveauId
     * @param formationUniversiteId
     * @return List of Formations
     */
    @GetMapping("/formations/typeFormation/{typeFormationId}/universite/{universiteId}")
    public ResponseEntity<List<Formation>> getFormationsByParamsTypeFormationIdAndUniversiteId(@PathVariable("typeFormationId") int typeFormationNiveauId,
                                                                                               @PathVariable("universiteId") int formationUniversiteId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByParamsTypeFormationIdAndUniversiteId(typeFormationNiveauId,formationUniversiteId),
                HttpStatus.OK);
    }

    /**
     * get all formation by NiveauId
     * @param formationNiveauId
     * @return List of Formation
     */
    @GetMapping("/formations/niveau/{formationNiveauId}")
    public ResponseEntity<List<Formation>> getFormationsByNiveauId(@PathVariable int formationNiveauId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByNiveauId(formationNiveauId),
                HttpStatus.OK);
    }

    /**
     * get all formations by TypeFormationId
     * @param formationTypeFormationId
     * @return List of formation
     */
    @GetMapping("/formations/typeFormation/{formationTypeFormationId}")
    public ResponseEntity<List<Formation>> getFormationsByTypeFormationId(@PathVariable int formationTypeFormationId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByTypeFormationId(formationTypeFormationId),
                HttpStatus.OK);
    }

    /**
     * get all formations by UniversiteId
     * @param formationUniversiteId
     * @return List of formation
     */
    @GetMapping("/formations/universite/uId/{formationUniversiteId}")
    public ResponseEntity<List<Formation>> getFormationsByUniversiteId(@PathVariable int formationUniversiteId){
        return new ResponseEntity<>(
                formationRepository.getFormationsByUniversiteId(formationUniversiteId),
                HttpStatus.OK);
    }

    /**
     * get le nombre total de formations
     * @return
     */
    @GetMapping("/formations/total")
    public int getNombresFormation() {
        return formationRepository.CountFormation();
    }


}
