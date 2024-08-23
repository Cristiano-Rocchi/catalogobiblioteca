package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libri extends CatalogoBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autore;
    private String genere;
    private String isbn;
    private LocalDate annoPubblicazione;

    // Costruttore predefinito
    public Libri() {
        super();
    }

    // Costruttore con argomenti
    public Libri(Long id, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere, String isbn) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
        this.isbn = isbn;
        this.annoPubblicazione = annoPubblicazione;
    }

    // Getters e setters
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
}
