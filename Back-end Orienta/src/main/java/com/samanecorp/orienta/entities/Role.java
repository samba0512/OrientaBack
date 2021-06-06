package com.samanecorp.orienta.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the libelle")
    @Size(max = 200, message = "The max of libelle is 200 characters.")
    private String libelle;
    @NotEmpty(message = "Please input the description")
    @Size(max = 255, message = "The max of description is 255 characters.")
    private String description;
    @Column(length = 1)
    private int etat;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Role(String libelle, String description, int etat, List<User> users) {
        this.libelle = libelle;
        this.description = description;
        this.etat = etat;
        this.users = users;
    }
}
