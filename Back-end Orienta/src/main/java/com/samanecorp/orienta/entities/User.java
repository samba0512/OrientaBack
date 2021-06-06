package com.samanecorp.orienta.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Please input your email.")
    @Email(message = "Email format is wrong.")
    private String email;
    @NotBlank(message = "Username cannot be empty")
    @Column(unique = true)
    @Size(min = 4, max = 100, message = "username must be between 4 and 100 characters in length.")
    private String username;
    @NotNull(message = "Password field cannot be empty.")
    @Size(min = 8, max = 110, message = "Password must be between 8 and 110 characters in length.")
    private String password;
    @NotBlank(message = "the created_at cannot be empty")
    private String created_at;
    @Column(length = 1)
    private int etat;
    private String filename;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public User(String email, String username, String password, String created_at, int etat) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.etat = etat;

    }
}
