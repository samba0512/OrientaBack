package com.samanecorp.orienta.controller;


import com.samanecorp.orienta.entities.*;
import com.samanecorp.orienta.repos.DemandeRepository;
import com.samanecorp.orienta.repos.DossierEtudiantRepository;
import com.samanecorp.orienta.repos.EtatRepository;
import com.samanecorp.orienta.repos.EtudiantRepository;
import com.samanecorp.orienta.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private DossierEtudiantRepository dossierEtudiantRepository;
    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Get all etudiants
     * @return
     */
    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    /**
     * Get etudiant by Id
     * @param etudiantId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable(value = "id") int etudiantId)
            throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id :: " + etudiantId));
        return ResponseEntity.ok().body(etudiant);
    }

    /**
     * Add a student
     * @param etudiant
     * @return
     */
    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@Valid @RequestBody Etudiant etudiant) {

        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        //pour hacher le mot de passe
        String hashPw = bCryptPasswordEncoder.encode(etudiant.getUser().getPassword());
        etudiant.getUser().setPassword(hashPw);
        //attribuer à created_at la date actuelle et fixer l'etat de l'etudiant à 1
        String dateFormat = s.format(date);
        etudiant.getUser().setCreated_at(dateFormat);
        etudiant.getUser().setEtat(1);
        etudiant.setNumero(LocalTime.now().toString());
        etudiant.setEtat(1);
        etudiant.setCreated_at(dateFormat);
        //Creer un dossier_etudiant et une demande apres creation de l'etudiant
        Etudiant e = etudiantRepository.save(etudiant);
        DossierEtudiant d = new DossierEtudiant();
        Demande de = new Demande();
        d.setEtudiant(e);
        EtatDossier etat = etudiantRepository.getEtatDossier(6);
        d.setEtatDossier(etat);
        int max = dossierEtudiantRepository.getMaxIdDossier();
        d.setNumero("DSE" + max);
        dossierEtudiantRepository.save(d);
        int max2 = demandeRepository.getMaxIdDemande();
        de.setMatricule("MDES" + max2);
        de.setEtudiant(e);
        de.setDossierEtudiant(d);
        de.setEtat(0);
        demandeRepository.save(de);
        return etudiantRepository.save(etudiant);
    }

    /**
     * save a student
     * @param file
     * @param student
     * @return
     */
    @PostMapping("/etudiants/saveProfile")
    public ResponseEntity<Response> saveEtudiantProfile(@RequestParam("file") List<MultipartFile> file , @RequestParam("student") String student) {

        try {
//            MultipartFile file2 = null;
            Etudiant etudiant = new ObjectMapper().readValue(student, Etudiant.class);
            etudiant.getUser().setFilename(file.get(0).getOriginalFilename());
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String hashPw = bCryptPasswordEncoder.encode(etudiant.getUser().getPassword());
            etudiant.getUser().setPassword(hashPw);
            String dateFormat = s.format(date);
            etudiant.getUser().setCreated_at(dateFormat);
            etudiant.getUser().setEtat(1);
            etudiant.setCreated_at(dateFormat);
            etudiant.setNumero(LocalTime.now().toString());

            String directory = SecurityConstants.cheminLocal;
            byte[] bytes = file.get(0).getBytes();
            Path path = Paths.get(directory + file.get(0).getOriginalFilename());
            Files.write(path, bytes);

            Etudiant dbUser = etudiantRepository.save(etudiant);
            DossierEtudiant d = new DossierEtudiant();
            Demande de = new Demande();
            d.setEtudiant(dbUser);
            EtatDossier etat = etudiantRepository.getEtatDossier(6);
            d.setEtatDossier(etat);
            int max = dossierEtudiantRepository.getMaxIdDossier();
            d.setNumero("DSE" + max);
            d.setFilenamecni(file.get(1).getOriginalFilename());

            byte[] bytes2 = file.get(1).getBytes();
            Path path2 = Paths.get(directory + file.get(1).getOriginalFilename());
            Files.write(path2, bytes2);

            dossierEtudiantRepository.save(d);
            int max2 = demandeRepository.getMaxIdDemande();
            de.setMatricule("MDES" + max2);
            de.setEtudiant(dbUser);
            de.setDossierEtudiant(d);
            de.setEtat(0);
            demandeRepository.save(de);
            if(dbUser!=null) {
                return new ResponseEntity<Response>(new Response("Student is saved Successfully"), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<Response>(new Response("Student is not saved"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }

    /**
     * Update les informations d'un etudiant
     * @param etudiantId
     * @param etudiantDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id") int etudiantId,
                                                   @Valid @RequestBody Etudiant etudiantDetails) throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id :: " + etudiantId));

        final Etudiant updatedEtudiant = etudiantRepository.saveAndFlush(etudiantDetails);
        return ResponseEntity.ok(updatedEtudiant);
    }

    /**
     * Delete un etudiant
     * @param etudiantId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/etudiants/{id}")
    public Map<String, Boolean> deleteEtudiant(@PathVariable(value = "id") int etudiantId)
            throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id :: " + etudiantId));

        etudiantRepository.delete(etudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * get all informations d'un etudiant en fonction de son email
     * @param email
     * @return
     */
    @GetMapping("/etudiants/Email/{email}")
    public Etudiant getEtudiantByEmail(@PathVariable(value = "email") String email)  {
        Etudiant etudiant = etudiantRepository.findByEmail(email);
        // Cryptage du Mot de Passe
        etudiant.getUser().setPassword("crypted");
        return etudiant;
    }

    /**
     * Get le nombre d'étudiants
     * @return
     */
    @GetMapping("/etudiants/total")
    public int getNombresEtudiant() {
        return etudiantRepository.CountEtudiant();
    }

    /**
     * get etudiant profil
     * @param imageName
     * @param response
     * @return
     */
    @GetMapping("/etudiants/getImage/{imageName}")
    public Object getImage(@PathVariable String imageName, HttpServletResponse response)  {

        InputStream io;
        try {
            io = new FileInputStream(SecurityConstants.cheminLocal+imageName);
            return IOUtils.copy(io, response.getOutputStream());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            return null;
        }

    }

    /**
     * get etudiant by numero Dossier
     * @param numeroDossier
     * @return
     */
    @GetMapping("/etudiants/Dossier/{numeroDossier}")
    public Etudiant getEtudiantByNumeroDossier(@PathVariable("numeroDossier") String numeroDossier){
                Etudiant etudiant = etudiantRepository.getEtudiantByNumeroDossier(numeroDossier);
                etudiant.getUser().setPassword("crypted");
                return etudiant;
    }


    /**
     * get etudiant by matricule demande
     * @param matricule
     * @return
     */
    @GetMapping("/etudiants/Demande/{matricule}")
    public Etudiant getEtudiantByMatriculeDemande(@PathVariable("matricule") String matricule){
        Etudiant etudiant = etudiantRepository.getEtudiantByMatriculeDemande(matricule);
        etudiant.getUser().setPassword("crypted");
        return etudiant;
    }

    /**
     * get etudiant by son numero
     * @param numero
     * @return
     */
    @GetMapping("/etudiants/Numero/{numero}")
    public Etudiant getEtudiantByNumero(@PathVariable("numero") String numero){
        Etudiant etudiant = etudiantRepository.getEtudiantByNumero(numero);
        etudiant.getUser().setPassword("crypted");
        return etudiant;
    }
}
