package com.samanecorp.orienta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FichiersDossiers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private MultipartFile[] files;
    private String path;
    private String type;
    @Column(length = 1)
    private int etat;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,optional = true)
    private DossierEtudiant dossierEtudiant ;

    public FichiersDossiers(String libelle, MultipartFile[] files, String path, String type, int etat) {
        this.libelle = libelle;
        this.files = files;
        this.path = path;
        this.type = type;
        this.etat = etat;
    }
}
