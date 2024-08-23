package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "catalogo_biblioteca")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CatalogoBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;

    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "numero_pagine")
    private int numeroPagine;

    public CatalogoBiblioteca(Long id, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public CatalogoBiblioteca() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
