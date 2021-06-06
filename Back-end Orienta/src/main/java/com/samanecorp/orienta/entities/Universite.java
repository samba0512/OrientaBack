package com.samanecorp.orienta.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the Univercity's name ")
    @Size(max = 250, message = "The max of Univercity's name is 250 characters.")
    @Column(unique=true)
    private String nom;
    @NotEmpty(message = "Please input the Univercity's adress ")
    @Size(max = 250, message = "The max of Univercity's adress is 250 characters.")
    private String adresse;
    @NotEmpty(message = "Please input the country ")
    @Size(max = 255, message = "The max of country is 255 characters.")
    private String pays;
    @NotEmpty(message = "Please input the description ")
    private String description;
    @NotEmpty(message = "Please input the language ")
    @Size(max = 100, message = "The max of language is 100 characters.")
    private String langue;
    @NotEmpty(message = "Please input the website ")
    @Size(max = 100, message = "The max of website is 100 characters.")
    private String site_web;
    @NotEmpty(message = "Please input the phone number ")
    private String telephone;
    private String Autres_infos;
    @OneToOne(cascade = CascadeType.PERSIST,optional = true)
    private User user ;



    public Universite(String nom, String adresse, String pays, User user) {
        this.nom = nom;
        this.adresse = adresse;
        this.pays = pays;
        this.user = user;
    }
}
