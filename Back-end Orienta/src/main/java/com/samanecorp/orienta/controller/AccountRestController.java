package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.RegisterForm;
import com.samanecorp.orienta.entities.User;
import com.samanecorp.orienta.repos.UserRepository;
import com.samanecorp.orienta.security.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserRepository userRepository;

    /**
     * Register
     * @param userForm
     * @return
     */
    @PostMapping("/register")
    public User register(@RequestBody RegisterForm userForm) {
        if(!userForm.getPassword().equals(userForm.getPassword()))
            throw new RuntimeException("You must confirm your password");
        User userr = userRepository.findByUsername(userForm.getUsername());
        if(userr != null)
            throw new RuntimeException("This user already exists");
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        accountService.saveUser(user);
        accountService.addRoleToUser(userForm.getUsername(), "USER");
        return user;
    }
}
