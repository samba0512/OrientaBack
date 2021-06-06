package com.samanecorp.orienta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samanecorp.orienta.entities.*;
import com.samanecorp.orienta.repos.ParcoursRepository;
import com.samanecorp.orienta.security.SecurityConstants;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class ParcoursController {

    @Autowired
    private ParcoursRepository parcoursRepository;

    /**
     * Get all parcours
     * @return
     */
    @GetMapping("/parcours")
    public List<Parcours> getAllParcours() {
        return parcoursRepository.findAll();
    }

    /**
     * get un parcours by son Id
     * @param parcoursId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/parcours/{id}")
    public ResponseEntity<Parcours> getParcoursById(@PathVariable(value = "id") int parcoursId)
            throws ResourceNotFoundException {
        Parcours parcours = parcoursRepository.findById(parcoursId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcours not found for this id :: " + parcoursId));
        return ResponseEntity.ok().body(parcours);
    }

    /**
     * Add a parcours
     * @param parcours
     * @return
     */
    @PostMapping("/parcours")
    public Parcours createParcours(@Valid @RequestBody Parcours parcours) {
        return parcoursRepository.save(parcours);
    }

    /**
     * add parcours with student files
     * @param file
     * @param parcour
     * @return
     */
    @PostMapping("/parcours/saveParcours")
    public ResponseEntity<Response> saveParcours(@RequestParam("file")  List<MultipartFile> file, @RequestParam("parcour") String parcour) {

        try {
            Parcours parcours = new ObjectMapper().readValue(parcour, Parcours.class);
            for(int i=0;i<3;i++) {
                parcours.setFilenamediplome(file.get(i).getOriginalFilename());

                String directory = SecurityConstants.cheminLocal;
                byte[] bytes = file.get(i).getBytes();
                Path path = Paths.get(directory + file.get(i).getOriginalFilename());
                Files.write(path, bytes);

                Parcours p = parcoursRepository.save(parcours);

                if(p!=null) {
                    return new ResponseEntity<Response>(new Response("parcours is saved Successfully"), HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<Response>(new Response("parcours is not saved"), HttpStatus.BAD_REQUEST);
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }

    /**
     * add parcours with student files
     * @param file
     * @param parcour
     * @return
     */
    @PostMapping("/parcours/saveParcours1")
    public ResponseEntity<Response> saveParcours1(@RequestParam("file") MultipartFile file, @RequestParam("parcour") String parcour) {

        try {
            Parcours parcours = new ObjectMapper().readValue(parcour, Parcours.class);

                parcours.setFilenamediplome(file.getOriginalFilename());

                String directory = SecurityConstants.cheminLocal;
                byte[] bytes = file.getBytes();
                Path path = Paths.get(directory + file.getOriginalFilename());
                Files.write(path, bytes);


            Parcours p = parcoursRepository.save(parcours);

            if(p!=null) {
                return new ResponseEntity<Response>(new Response("parcours is saved Successfully"), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<Response>(new Response("parcours is not saved"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }

    /**
     * get file
     * @param imageName
     * @param response
     * @return
     */
    @GetMapping("/parcours/getImage/{imageName}")
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
     * Update a parcours
     * @param parcoursId
     * @param parcoursDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/parcours/{id}")
    public ResponseEntity<Parcours> updateParcours(@PathVariable(value = "id") int parcoursId,
                                             @Valid @RequestBody Parcours parcoursDetails) throws ResourceNotFoundException {
        Parcours parcours = parcoursRepository.findById(parcoursId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcours not found for this id :: " + parcoursId));


        final Parcours updatedParcours = parcoursRepository.saveAndFlush(parcoursDetails);
        return ResponseEntity.ok(updatedParcours);
    }

    /**
     * Delete un parcours
     * @param parcoursId
     * @return
     * @throws ResourceNotFoundException
     */

    @DeleteMapping("/parcours/{id}")
    public Map<String, Boolean> deleteParcours(@PathVariable(value = "id") int parcoursId)
            throws ResourceNotFoundException {
        Parcours parcours = parcoursRepository.findById(parcoursId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcours not found for this id :: " + parcoursId));

        parcoursRepository.delete(parcours);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get all parcours by etudiant id
     * @param EtudiantId
     * @return
     */
    @GetMapping("/parcours/etudiant/{id}")
    public List<Parcours> getParcoursByEtudiantId(@PathVariable(value = "id") int EtudiantId)  {
        List<Parcours> parcours = parcoursRepository.getParcoursByEtudiantId(EtudiantId);
        return parcours;
    }
}
