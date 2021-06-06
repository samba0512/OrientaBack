package com.samanecorp.orienta.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.samanecorp.orienta.entities.Formation;
import com.samanecorp.orienta.entities.Universite;
import com.samanecorp.orienta.repos.UniversiteRepository;
import com.samanecorp.orienta.security.SecurityConstants;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class UniversiteController {

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ServletContext context;

    /**
     * Get all universities
     * @return
     */
    @GetMapping("/universites")
    public List<Universite> getAllUniversites()
    {
        return universiteRepository.findAll();
    }

    /**
     * Get university by Id
     * @param universiteId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/universites/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable(value = "id") int universiteId)
            throws ResourceNotFoundException {
        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new ResourceNotFoundException("Universite not found for this id :: " + universiteId));
        return ResponseEntity.ok().body(universite);
    }

    /**
     * Add an university
     * @param universite
     * @return
     */
    @PostMapping("/universites")
    public Universite createUniversite(@Valid @RequestBody Universite universite) {
        String hashPw = bCryptPasswordEncoder.encode(universite.getUser().getPassword());
        universite.getUser().setPassword(hashPw);
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateFormat = s.format(date);
        universite.getUser().setCreated_at(dateFormat);
        universite.getUser().setEtat(1);

        return universiteRepository.save(universite);
    }


    @PostMapping("/universites/saveProfile")
    public ResponseEntity<Response> saveUniversityProfile(@RequestParam("file") MultipartFile file, @RequestParam("university") String university) {

        try {
//            System.out.println(file.getBytes());
//            System.exit(1);
            Universite universite = new ObjectMapper().readValue(university, Universite.class);
//            universite.getUser().setProfil(file.getBytes());
            universite.getUser().setFilename(file.getOriginalFilename());
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String hashPw = bCryptPasswordEncoder.encode(universite.getUser().getPassword());
            universite.getUser().setPassword(hashPw);
            String dateFormat = s.format(date);
            universite.getUser().setCreated_at(dateFormat);
            universite.getUser().setEtat(1);

            String directory = SecurityConstants.cheminLocal;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(directory + file.getOriginalFilename());
            Files.write(path, bytes);

            Universite dbUser = universiteRepository.save(universite);
            if(dbUser!=null) {
                return new ResponseEntity<Response>(new Response("University is saved Successfully"), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<Response>(new Response("University is not saved"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }

    /**
     * Update les informations d'une universite
     * @param universiteId
     * @param UniversiteDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/universites/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable(value = "id") int universiteId,
                                           @Valid @RequestBody Universite UniversiteDetails) throws ResourceNotFoundException {
        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new ResourceNotFoundException("Universite not found for this id :: " + universiteId));

        final Universite updatedUniversite = universiteRepository.saveAndFlush(UniversiteDetails);
        return ResponseEntity.ok(updatedUniversite);
    }

    /**
     * Delete an university
     * @param universiteId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/universites/{id}")
    public Map<String, Boolean> deleteUniversite(@PathVariable(value = "id") int universiteId)
            throws ResourceNotFoundException {
        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new ResourceNotFoundException("Universite not found for this id :: " + universiteId));

        universiteRepository.delete(universite);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get university by email
     * @param email
     * @return
     */
    @GetMapping("/universites/Email/{email}")
    public Universite getUniversiteByEmail(@PathVariable(value = "email") String email)  {
        Universite universite = universiteRepository.findUniversiteByEmail(email);
        // Cryptage du Mot de Passe
        universite.getUser().setPassword("crypted");
        return universite;
    }

    /**
     * Get count universities
     * @return
     */
    @GetMapping("/universites/total")
    public int getNombresUniversites() {
        return universiteRepository.CountUniversite();
    }

    /**
     * get iuniversity profil
     * @param imageName
     * @param response
     * @return
     */
    @GetMapping("/universites/getImage/{imageName}")
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


    @GetMapping("/universites/nom/{Universitynom}")
    public Universite getUniversiteByNom(@PathVariable("Universitynom") String Universitynom){
                Universite universite = universiteRepository.getUNiversityByNom(Universitynom);
                universite.getUser().setPassword("crypted");
                return universite;
    }
}
