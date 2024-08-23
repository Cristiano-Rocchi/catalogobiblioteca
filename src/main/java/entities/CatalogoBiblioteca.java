package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "catalogo_biblioteca")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CatalogoBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;

    @Column(name = "anno_pubblicazione")
    private Date annoPubblicazione;

    @Column(name = "numero_pagine")
    private int numeroPagine;

    // Getters e Setters
}
