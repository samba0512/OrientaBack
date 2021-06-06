package com.samanecorp.orienta.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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
public class EtatDossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the libelle of state")
    @Size(max = 35, message = "The max of libelle is 35 characters.")
    @Column(unique = true)
    private String libelle;

    public EtatDossier(String libelle) {
        this.libelle = libelle;
    }
}
