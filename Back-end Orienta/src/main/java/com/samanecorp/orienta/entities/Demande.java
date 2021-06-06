package com.samanecorp.orienta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    @Size(max = 100, message = "le matricule ne doit pas dépasser 100 characters")
    private String matricule;
    @Column(length = 1)
    private int etat;
    @ManyToOne(cascade =  CascadeType.PERSIST, fetch = FetchType.EAGER,  optional = true)
    private Universite universite ;
    @OneToOne(cascade =  CascadeType.PERSIST, fetch = FetchType.EAGER,  optional = true)
    private Entretien entretien;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,  optional = true)
    private Formation formation ;
    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER,  optional = true)
    private Paiement paiement ;
    @OneToOne(cascade =  CascadeType.PERSIST, fetch = FetchType.EAGER,  optional = true)
    private Etudiant etudiant ;
    @OneToOne(cascade =  CascadeType.PERSIST, fetch = FetchType.EAGER,  optional = true)
    private DossierEtudiant dossierEtudiant;

    public Demande(String matricule, int etat, Universite universite, Entretien entretien, Formation formation, Paiement paiement, Etudiant etudiant, DossierEtudiant dossierEtudiant) {
        this.matricule = matricule;
        this.etat = etat;
        this.universite = universite;
        this.entretien = entretien;
        this.formation = formation;
        this.paiement = paiement;
        this.etudiant = etudiant;
        this.dossierEtudiant = dossierEtudiant;
    }
}
