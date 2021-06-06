package com.samanecorp.orienta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samanecorp.orienta.entities.User;
import com.samanecorp.orienta.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * get all users
     * @return
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Add a user
     * @param user
     * @return
     */
    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User user) {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        String dateFormat = s.format(date);
        user.setCreated_at(dateFormat);
        user.setEtat(1);
        return userRepository.save(user);
    }

    /**
     * get user By Id
     * @param userId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    /**
     * Update les informations d'un user
     * @param userId
     * @param UserDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @Valid @RequestBody User UserDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        final User updatedUser = userRepository.saveAndFlush(UserDetails);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete a user
     * @param userId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
