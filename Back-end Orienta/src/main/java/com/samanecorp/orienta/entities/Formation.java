package com.samanecorp.orienta.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the libelle")
    private String libelle;
    @Column(length = 8000, nullable = true)
    private String description;
    @Column(length = 600, nullable = true)
    private String Autre_infos;
    @Column(length = 1)
    private int etat;
    @NotEmpty(message = "Please input the start day")
    private String Start_Day;
    @NotEmpty(message = "Please input the end day")
    private String End_Day;
    @NotNull(message = "Please input the fees")
    private int frais;
    @ManyToOne(fetch = FetchType.EAGER,  optional = true)
    private DomaineFormation domaineFormation ;
    @ManyToOne(fetch = FetchType.EAGER,  optional = true)
    private Universite universite;
    @OneToOne(fetch = FetchType.EAGER,  optional = true)
    @JoinColumn(name = "niveau_id",referencedColumnName = "id")
    private Niveau niveau;
    @OneToOne(fetch = FetchType.EAGER,  optional = true)
    @JoinColumn(name="type_formations_id",referencedColumnName = "id")
    private TypeFormations typeFormations;


    public Formation(String libelle, int etat, DomaineFormation domaineFormation) {
        this.libelle = libelle;
        this.etat = etat;
        this.domaineFormation = domaineFormation;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }
}
