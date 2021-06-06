package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Agent;
import com.samanecorp.orienta.entities.Etudiant;
import com.samanecorp.orienta.repos.AgentRepository;
import com.samanecorp.orienta.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.apache.commons.io.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samanecorp.orienta.security.SecurityConstants;


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
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * get all agents
     * @return
     */
    @GetMapping("/agents")
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    /**
     * get un agent by son Id
     * @param agentId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/agents/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable(value = "id") int agentId)
            throws ResourceNotFoundException {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + agentId));
        return ResponseEntity.ok().body(agent);
    }

    /**
     * save admin profil
     * @param file
     * @param admin
     * @return
     */
    @PostMapping("/agents/saveProfile")
    public ResponseEntity<Response> saveAgentProfile(@RequestParam("file") MultipartFile file, @RequestParam("admin") String admin) {

        try {

            Agent agent = new ObjectMapper().readValue(admin, Agent.class);
            agent.getUser().setFilename(file.getOriginalFilename());
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String hashPw = bCryptPasswordEncoder.encode(agent.getUser().getPassword());
            agent.getUser().setPassword(hashPw);
            String dateFormat = s.format(date);
            agent.getUser().setCreated_at(dateFormat);
            agent.getUser().setEtat(1);

            String directory = SecurityConstants.cheminLocal;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(directory + file.getOriginalFilename());
            Files.write(path, bytes);

            Agent dbUser = agentRepository.save(agent);
            if(dbUser!=null) {
                return new ResponseEntity<Response>(new Response("Admin is saved Successfully"), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<Response>(new Response("Admin is not saved"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }

    /**
     * get admin profil
     * @param imageName
     * @param response
     * @return
     */
    @GetMapping("/agents/getImage/{imageName}")
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
     * Add un agent
     * @param agent
     * @return
     */
    @PostMapping("/agents")
    public Agent createAgent(@Valid @RequestBody Agent agent) {
        String hashPw = bCryptPasswordEncoder.encode(agent.getUser().getPassword());
        agent.getUser().setPassword(hashPw);
        return agentRepository.save(agent);
    }

    /**
     * Update un agent
     * @param agentId
     * @param agentDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/agents/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable(value = "id") int agentId,
                                             @Valid @RequestBody Agent agentDetails) throws ResourceNotFoundException {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + agentId));
        final Agent updatedAgent = agentRepository.saveAndFlush(agentDetails);
        return ResponseEntity.ok(updatedAgent);
    }

    /**
     * Delete un agent
     * @param agentId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/agents/{id}")
    public Map<String, Boolean> deleteAgent(@PathVariable(value = "id") int agentId)
            throws ResourceNotFoundException {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + agentId));

        agentRepository.delete(agent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * Get les informations d'un administrateur(agent) by son email
     * @param email
     * @return
     */
    @GetMapping("/agents/Email/{email}")
    public Agent getAgentByEmail(@PathVariable(value = "email") String email)  {
        Agent agent = agentRepository.findAgentByEmail(email);
        // Cryptage du Mot de Passe
        agent.getUser().setPassword("crypted");
        return agent;
    }


}
