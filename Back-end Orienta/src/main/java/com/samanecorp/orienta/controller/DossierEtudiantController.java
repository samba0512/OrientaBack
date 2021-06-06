package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.DomaineFormation;
import com.samanecorp.orienta.entities.DossierEtudiant;
import com.samanecorp.orienta.entities.EtatDossier;
import com.samanecorp.orienta.entities.User;
import com.samanecorp.orienta.repos.DomaineFormationRepository;
import com.samanecorp.orienta.repos.DossierEtudiantRepository;
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
public class DossierEtudiantController {

    @Autowired
    private DossierEtudiantRepository dossierEtudiantRepository;

    /**
     * Get all dossiers etudiants
     * @return
     */
    @GetMapping("/dossierEtudiants")
    public List<DossierEtudiant> getAllDossierEtudiants() {
        return dossierEtudiantRepository.findAll();
    }

    /**
     * Get dossier etudiant by Id
     * @param dossierEtudiantId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/dossierEtudiants/{id}")
    public ResponseEntity<DossierEtudiant> getDossierEtudiantById(@PathVariable(value = "id") int dossierEtudiantId)
            throws ResourceNotFoundException {
        DossierEtudiant dossierEtudiant = dossierEtudiantRepository.findById(dossierEtudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Dossier Etudiant not found for this id :: " + dossierEtudiantId));
        return ResponseEntity.ok().body(dossierEtudiant);
    }

    /**
     * Get all dossiers acceptés
     * @return
     */
    @GetMapping("/dossierEtudiants/DossiersAcceptes")
    public List<DossierEtudiant> getDossiersValides() {
        return dossierEtudiantRepository.getDossierByEtat(1);
    }

    /**
     * get all dossiers en attente de validation
     * @return
     */
    @GetMapping("/dossierEtudiants/DossiersEnAttenteValidation")
    public List<DossierEtudiant> getDossiersAttenteValidation() {
        return dossierEtudiantRepository.getDossierByEtat(2);
    }

    /**
     * Get all dossiers complets
     * @return
     */
    @GetMapping("/dossierEtudiants/DossiersComplets")
    public List<DossierEtudiant> getDossiersComplets() {
        return dossierEtudiantRepository.getDossierByEtat(3);
    }

    /**
     * get all dossiers soumis à l'universite
     * @return
     */
    @GetMapping("/dossierEtudiants/DossiersSoumisAlUniversite")
    public List<DossierEtudiant> getDossiersSoumis() {
        return dossierEtudiantRepository.getDossierByEtat(4);
    }

    /**
     * Get all dossiers en attente de complément
     * @return
     */
    @GetMapping("/dossierEtudiants/DossiersEnAttenteComplement")
    public List<DossierEtudiant> getDossiersEnAttenteComplement() {
        return dossierEtudiantRepository.getDossierByEtat(5);
    }

    /**
     * get all dossiers en cours de creation
     * @return
     */
    @GetMapping("/dossierEtudiants/DossiersEnCoursDeCreation")
    public List<DossierEtudiant> getDossiersEnCoursCreation() {
        return dossierEtudiantRepository.getDossierByEtat(6);
    }

    /**
     * get le id max des dossiers
     * @return
     */
    //recuperer le max id de dossier_etudiant
    @GetMapping("/dossierEtudiants/Maxid")
    public int getMaxIdDossier() {
        return dossierEtudiantRepository.getMaxIdDossier();
    }

    /**
     * Add un dossier etudiant
     * @param dossierEtudiant
     * @return
     */
    @PostMapping("/dossierEtudiants")
    public DossierEtudiant createDossierEtudiant(@Valid @RequestBody DossierEtudiant dossierEtudiant) {
        return dossierEtudiantRepository.save(dossierEtudiant);
    }

    /**
     * Update un dossier etudiant
     * @param dossierEtudiantId
     * @param dossierEtudiantDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/dossierEtudiants/{id}")
    public ResponseEntity<DossierEtudiant> updateDossierEtudiant(@PathVariable(value = "id") int dossierEtudiantId,
            @Valid @RequestBody DossierEtudiant dossierEtudiantDetails) throws ResourceNotFoundException {
        DossierEtudiant dossierEtudiant = dossierEtudiantRepository.findById(dossierEtudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Dossier Etudiant not found for this id :: " + dossierEtudiantId));

        final DossierEtudiant updatedDossierEtudiant = dossierEtudiantRepository.saveAndFlush(dossierEtudiantDetails);
        return ResponseEntity.ok(updatedDossierEtudiant);
    }

    /**
     * Delete un dossier etudiant
     * @param dossierEtudiantId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/dossierEtudiants/{id}")
    public Map<String, Boolean> deleteDossierEtudiant(@PathVariable(value = "id") int dossierEtudiantId)
            throws ResourceNotFoundException {
        DossierEtudiant dossierEtudiant = dossierEtudiantRepository.findById(dossierEtudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Dossier Etudiant not found for this id :: " + dossierEtudiantId));

        dossierEtudiantRepository.delete(dossierEtudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get dossier etudiant en fonction de l'id de l'etudiant
     * @param etudiantId
     * @return
     */
    @GetMapping("/dossierEtudiants/ByEtudiant/{id}")
    public DossierEtudiant getDossierByEtudiant(@PathVariable(value = "id") int etudiantId)  {
        return dossierEtudiantRepository.getDossierByEtudiant(etudiantId);

    }

    /**
     * Get etat dossier etudiant en fonction de l'id de l'etudiant
     * @param etudiantId
     * @return
     */
    @GetMapping("/dossierEtudiants/EtatByEtudiant/{id}")
    public EtatDossier getEtatDossierByEtudiant(@PathVariable(value = "id") int etudiantId)  {
        EtatDossier etatDossier = dossierEtudiantRepository.getEtatDossierByIDEtudiant(etudiantId);
        return etatDossier;
    }

    /**
     * Get count des dossiers etudiants
     * @return
     */
    //fonction qui recupere le nombres de dossiers etudiants
    @GetMapping("/dossierEtudiants/total")
    public int getNombresDossiersEtudiant() {
        return dossierEtudiantRepository.CountDossierEtudiant();
    }

}
