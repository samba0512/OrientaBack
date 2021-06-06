package com.samanecorp.orienta.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Etudiant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input your firstname")
    @Size(max = 200, message = "The max of firstname is 200 characters.")
    private String firstname;
    @NotEmpty(message = "Please input your lastname.")
    @Size(max = 150, message = "The max of lastname is 150 characters.")
    private String lastname;
    @Column(unique=true)
    private String numero;
    @NotBlank(message = "Please input your phone number.")
    @Column(unique=true)
    private String telephone;
    @NotBlank(message = "Please input your date de naissance.")
    private String DateNaissance;
    @NotBlank(message = "Please input your lieu de naissance.")
    private String lieuNaissance;
    @NotBlank(message = "Please input your adress.")
    private String adresse;
    @NotBlank(message = "Please input your country.")
    private String pays;
    @NotBlank(message = "Please input your level of studies.")
    private String niveau;
    private String created_at;
    @NotBlank(message = "Please input your piece number.")
    private String numeroPiece;
    @Column(length = 1)
    private int etat;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    private TypePiece typePiece;


    public Etudiant(String firstname, String lastname, String numero, String telephone, String dateNaissance, String lieuNaissance, String adresse, String pays, String niveau, String created_at, String numeroPiece, int etat) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numero = numero;
        this.telephone = telephone;
        DateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.pays = pays;
        this.niveau = niveau;
        this.created_at = created_at;
        this.numeroPiece = numeroPiece;
        this.etat = etat;
    }
}
