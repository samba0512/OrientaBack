package com.samanecorp.orienta.entities;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input your firstname")
    @Size(max = 40, message = "The max of firstname is 40 characters.")
    private String firstname;
    @NotEmpty(message = "Please input your lastname.")
    @Size(max = 30, message = "The max of lastname is 30 characters.")
    private String lastname;
    @NotBlank(message = "Please input your phone number.")
    @Size(message = "Please enter a phone number with 13 characters")
    @Column(unique=true, length=13)
    private String telephone;
    @Size(max = 60, message = "The max of adresse is 60 characters")
    @NotNull(message = "Please input your adresse.")
    private String adresse;
    @Column(length = 1)
    private int etat;

    @OneToOne(cascade = CascadeType.PERSIST, optional = true)
    private User user ;

    public Agent(String firstname, String lastname, String telephone, String adresse, int etat, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.adresse = adresse;
        this.etat = etat;
        this.user = user;
    }

}
