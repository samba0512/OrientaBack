package com.samanecorp.orienta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Parcours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    @NotEmpty(message = "Please input the level")
    private String niveau;
    @NotEmpty(message = "Please input the year")
    private String annee;
    @NotEmpty(message = "Please input the school's name")
    private String NomEcole;
    @NotEmpty(message = "Please input the domaine")
    private String domaine;
    @NotEmpty(message = "Please input the city")
    private String ville;
    @NotEmpty(message = "Please input the country")
    private String pays;
    private String filenamediplome;
//    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,optional = true)
//    private Etudiant etudiant;
    private int etudiant_id;

    public Parcours(String niveau, String annee, String nomEcole, String domaine, String ville, String pays) {
        this.niveau = niveau;
        this.annee = annee;
        this.NomEcole = nomEcole;
        this.domaine = domaine;
        this.ville = ville;
        this.pays = pays;
        //this.etudiant_id = etudiant_id;
    }
}
