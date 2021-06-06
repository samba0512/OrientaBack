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
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the number")
    @Size(max = 30, message = "The max of number is 30 characters.")
    @Column(unique=true)
    private String numero;
    @NotEmpty(message = "Please input the description")
    @Size(max = 155, message = "The max of description is 155 characters.")
    private String description;
    @Size(max = 7, message = "The max of montant is 7 characters.")
    private Double montant;
    @Column(length = 1)
    private int etat;


    public Paiement(String numero, String description, Double montant, int etat) {
        this.numero = numero;
        this.description = description;
        this.montant = montant;
        this.etat = etat;
    }
}
