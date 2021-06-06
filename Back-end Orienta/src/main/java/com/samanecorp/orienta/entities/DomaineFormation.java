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
public class DomaineFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the libelle")
    @Size(max = 750, message = "The max of libelle is 100 characters.")
    private String libelle;
    @NotEmpty(message = "Please input the description")
    @Size(max = 8000, message = "The max of description is 150 characters.")
    private String description;
    @Column(length = 1)
    private int etat;


    public DomaineFormation(String libelle, String description, int etat) {
        this.libelle = libelle;
        this.description = description;
        this.etat = etat;
    }
}
