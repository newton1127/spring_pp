package com.example.demo.entities;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Column(length = 50)
    @OrderBy
    private String titre;
    @Column( updatable = false)
    private String maison_edition;
    private Date date_sortie;

    private String auteur;
    @Column( updatable = false)
    private int isbn;
    private Date date_consultation;
    private boolean isAvailable;
}
