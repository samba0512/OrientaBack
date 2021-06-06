package com.samanecorp.orienta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please input the subject of the message")
    @Size(max = 150, message = "The max of subject is 150 characters.")
    private String subject;
    @NotEmpty(message = "Please input the content of the message")
    @Size(max = 255, message = "The max of content is 255 characters.")
    private String content;
    private int _from;
    private int _to;
    @Column(length = 1)
    private int etat;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,optional = true)
    private User user ;

    public Message(String subject, String content, int _from, int _to, int etat, User user) {
        this.subject = subject;
        this.content = content;
        this._from = _from;
        this._to = _to;
        this.etat = etat;
        this.user = user;
    }
}
