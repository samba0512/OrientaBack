package com.samanecorp.orienta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Pays {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int num_code;
    private String alpha_2_code;
    private String alpha_3_code;
    private String en_short_name;
    private String nationality;

    /**
     * `num_code` int(3) NOT NULL DEFAULT '0',
     *   `alpha_2_code` varchar(2) DEFAULT NULL,
     *   `alpha_3_code` varchar(3) DEFAULT NULL,
     *   `en_short_name` varchar(52) DEFAULT NULL,
     *   `nationality` varchar(39) DEFAULT NULL,
     */
}
