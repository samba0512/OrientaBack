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
public class DossierEtudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String numero;
    @Column(nullable = true)
    private String autres_infos;
    private String filenamecni;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    private Etudiant etudiant;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,optional = true)
    private EtatDossier etatDossier;

    public DossierEtudiant(String numero, int etat, String autres_infos, Etudiant etudiant) {
        this.numero = numero;
        this.autres_infos = autres_infos;
        this.etudiant = etudiant;
    }
}
