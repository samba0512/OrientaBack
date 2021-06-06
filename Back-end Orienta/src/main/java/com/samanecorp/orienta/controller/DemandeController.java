package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Agent;
import com.samanecorp.orienta.entities.Demande;
import com.samanecorp.orienta.entities.EtatDossier;
import com.samanecorp.orienta.repos.AgentRepository;
import com.samanecorp.orienta.repos.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
public class DemandeController {

    @Autowired
    private DemandeRepository demandeRepository;

    /**
     * Get all demandes
     * @return
     */
    @GetMapping("/demandes")
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    /**
     * Get demande by son Id
     * @param demandeId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/demandes/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable(value = "id") int demandeId)
            throws ResourceNotFoundException {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + demandeId));
        return ResponseEntity.ok().body(demande);
    }

    /**
     * Get all demandes soumises à une universite en fonction de son email
     * @param email
     * @return
     */
    @GetMapping("/demandes/soumis/{email}")
    public List<Demande> getDemandesSos(@PathVariable(value = "email") String email)  {
        List<Demande> demande = demandeRepository.getDemandeSoumis(email);
        return demande;
    }

    /**
     * Get all demandes soumises à une universite en fonction de son email et de l'etat du dossier
     * @param email
     * @return
     */
    @GetMapping("/demandes/universite/{email}")
    public List<Demande> getDemandeSoumisUniversite(@PathVariable(value = "email") String email) {
        List<Demande> demande = demandeRepository.getDemandeByEMailUniversite(4, email);
        return demande;
    }

    /**
     * Get le id max des demandes
     * @return
     */
    @GetMapping("/demandes/Maxid")
    public int getMaxIdDossier() {
        return demandeRepository.getMaxIdDemande();
    }

    /**
     * Add une demande
     * @param demande
     * @return
     */
    @PostMapping("/demandes")
    public Demande createDemande(@Valid @RequestBody Demande demande) {
        return demandeRepository.save(demande);
    }

    /**
     * Update une demande
     * @param demandeId
     * @param demandeDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/demandes/{id}")
    public ResponseEntity<Demande> updateDemande( @PathVariable(value = "id") int demandeId,
            @Valid @RequestBody Demande demandeDetails) throws ResourceNotFoundException {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + demandeId));

        final Demande updatedDemande = demandeRepository.saveAndFlush(demandeDetails);
        return ResponseEntity.ok(updatedDemande);
    }

    /**
     * Delete une demande
     * @param demandeId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/demandes/{id}")
    public Map<String, Boolean> deleteDemande(@PathVariable(value = "id") int demandeId)
            throws ResourceNotFoundException {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + demandeId));

        demandeRepository.delete(demande);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get all demandes soumises à une universite en fonction de son Id
     * @param id
     * @return
     */
    @GetMapping("/demandes/universite/soumis/{id}")
    public List<Demande> getDemandesSoumis(@PathVariable(value = "id") int id)  {
        List<Demande> demande = demandeRepository.getDemandeSoumisByIdUniversite(id);
        return demande;
    }

    /**
     * Get all demandes soumises
     * @return
     */
    @GetMapping("/demandes/soumises")
    public List<Demande> getDemandesSoumisAdmin()  {
        List<Demande> demande = demandeRepository.getDemandeSoumisAdmin();
        return demande;
    }

    /**
     * Get all demandes acceptes
     * @return
     */
    @GetMapping("/demandes/acceptes")
    public List<Demande> getDemandesAcceptes()  {
        List<Demande> demande = demandeRepository.getDemandeAcceptesAdmin();
        return demande;
    }

    /**
     * Get all demandes en attente de validation
     * @return
     */
    @GetMapping("/demandes/EnAttenteValidation")
    public List<Demande> getDemandesEnAttenteV()  {
        List<Demande> demande = demandeRepository.getDemandeEnAttenteValidation();
        return demande;
    }

    /**
     * Get all demandes en attente de complément
     * @return
     */
    @GetMapping("/demandes/EnAttenteComplement")
    public List<Demande> getDemandesEnAttenteC()  {
        List<Demande> demande = demandeRepository.getDemandeEnAttenteComplement();
        return demande;
    }

    /**
     * Get all demandes en cours de creation
     * @return
     */
    @GetMapping("/demandes/EnCoursCreation")
    public List<Demande> getDemandesEnCoursCreation()  {
        List<Demande> demande = demandeRepository.getDemandeEnCoursDeCreation();
        return demande;
    }

    /**
     * get demandes rejetées
     * @return
     */
    @GetMapping("/demandes/Rejete")
    public List<Demande> getDemandesRejetes()  {
        List<Demande> demande = demandeRepository.getDemandeRejetes();
        return demande;
    }

    /**
     * Get all demandes complets
     * @return
     */
    @GetMapping("/demandes/Complets")
    public List<Demande> getDemandesComplets()  {
        List<Demande> demande = demandeRepository.getDemandeComplets();
        return demande;
    }

    /**
     * Get demande by etudiant Id
     * @param id
     * @return
     */
    @GetMapping("/demandes/etudiants/{id}")
    public List<Demande> getDemandesEtudiant(@PathVariable(value = "id") int id)  {
        List<Demande> demande = demandeRepository.getDemandeByEtudiantId(id);
        return demande;
    }

    /**
     * Get demande by etudiant Id
     * @param etudiantId
     * @return
     */
    @GetMapping("/demandes/Etudiants/ByEtudiant/{id}")
    public Demande getDemandeByEtudiant(@PathVariable(value = "id") int etudiantId)  {
        return  demandeRepository.getDemandeByEtudiant(etudiantId);

    }

    /**
     * Get le nombre de demandes
     * @return
     */
    @GetMapping("/demandes/total")
    public int getNombresDemande() {
        return demandeRepository.CountDemande();
    }

    /**
     * function pour valider les demandes coté université
     * @param id
     * @return
     */
    @GetMapping("/demandes/valider/{id}")
    public Demande validerDemande(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            EtatDossier e = demandeRepository.getEtatDossier(1);
            d.getDossierEtudiant().setEtatDossier(e);
            d = demandeRepository.saveAndFlush(d);
        }
        return d;
    }

    /**
     * function pour rejeter les demandes coté université
     * @param id
     * @return
     */
    @GetMapping("/demandes/rejeter/{id}")
    public Demande rejeterDemande(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            d.setEtat(0);
            d = demandeRepository.saveAndFlush(d);
        }
        System.out.println(d.getEtat());
        return d;
    }

    /**
     * rejeter demande partie université
     */
    @GetMapping("/demandes/universite/rejet/{id}")
    public Demande rejetrerDemandeUniversite(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            EtatDossier e = demandeRepository.getEtatDossier(7);
            d.getDossierEtudiant().setEtatDossier(e);
            d = demandeRepository.saveAndFlush(d);
        }
        return d;
    }


    /**
     * function pour valider les demandes en attente de validation coté admin
     * @param id
     * @return
     */
    @GetMapping("/demandes/EnAttenteValidation/valider/{id}")
    public Demande validerDemandeEnattenteValidation(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            EtatDossier e = demandeRepository.getEtatDossier(3);
            d.getDossierEtudiant().setEtatDossier(e);
            d = demandeRepository.saveAndFlush(d);
        }
        return d;
    }

    /**
     * function pour demander des complements aux demandes en attente de validation coté admin
     * @param id
     * @return
     */
    @GetMapping("/demandes/EnAttenteValidation/rejet/{id}")
    public Demande rejetrerDemandeEnattenteValidation(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            EtatDossier e = demandeRepository.getEtatDossier(5);
            d.getDossierEtudiant().setEtatDossier(e);
            d = demandeRepository.saveAndFlush(d);
        }
        return d;
    }


    /**
     * function pour valider les demandes en attente de complément coté admin
     * @param id
     * @return
     */
    @GetMapping("/demandes/EnAttenteComplement/valider/{id}")
    public Demande validerDemandeEnattenteComplement(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            EtatDossier e = demandeRepository.getEtatDossier(2);
            d.getDossierEtudiant().setEtatDossier(e);
            d = demandeRepository.saveAndFlush(d);
        }
        return d;
    }

    /**
     * function pour valider les demandes complets coté admin
     * @param id
     * @return
     */
    @GetMapping("/demandes/Complets/valider/{id}")
    public Demande validerDemandeComplets(@PathVariable(value = "id") int id) {

        Demande d = demandeRepository.getDemande(id);
        if (d != null) {
            EtatDossier e = demandeRepository.getEtatDossier(4);
            d.getDossierEtudiant().setEtatDossier(e);
            d = demandeRepository.saveAndFlush(d);
        }
        return d;
    }

    /**
     * Get les 5 dernieres demandes en attente de validation
     * @return
     */
    @GetMapping("/demandes/5dernieres/EnAttenteValidation")
    public List<Demande> getDerniresDemandesEnAttenteV()  {
        int d = demandeRepository.CountDemandeEnAttenteV();
        int size = 5;
        int db = (int) Math.floor(d/size);
        if(d%size>0)
            db++;
        List<Demande> demande = demandeRepository.getDernieresDemandeEnAttenteValidation(PageRequest.of(db-1,size));
        return demande;
    }

    /**
     * Get les 5 dernieres demandes en attente de complement
     * @return
     */
    @GetMapping("/demandes/5dernieres/EnAttenteComplement")
    public List<Demande> getDerniresDemandesEnAttenteC()  {
        int d = demandeRepository.CountDemandeEnAttenteC();
        int size = 5;
        int db = (int) Math.floor(d/size);
        if(d%size>0)
            db++;
        List<Demande> demande = demandeRepository.getDernieresDemandeEnAttenteComplement(PageRequest.of(db-1,size));
        return demande;
    }

    /**
     * get le nombre de demandes soumises aux universités
     * @return
     */
    @GetMapping("/demandes/Soumises/total")
    public int getNombresDemandeSoumis() {
        return demandeRepository.CountDemandeSoumisesUniversite();
    }

    /**
     * Get le nombre de demandes soumises d'une université en particulier
     * @return
     */
    @GetMapping("/demandes/soumisesTotal/{id}")
    public int getNombresDemandeSoumisByIdUniversity(@PathVariable(value = "id") int id) {
        return demandeRepository.CountDemandeSoumisByIdUniversite(id);
    }

}
