package com.samanecorp.orienta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class TopUniversite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int position;
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    private Universite universite ;

    public TopUniversite(int position, Universite universite) {
        this.position = position;
        this.universite = universite;
    }

    public TopUniversite(int position) {
        this.position = position;
    }
}
