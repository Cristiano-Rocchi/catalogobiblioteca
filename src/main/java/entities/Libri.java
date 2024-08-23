package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libri extends CatalogoBiblioteca {

    private String autore;
    private String genere;
    private String isbn; // Aggiungi ISBN come proprietà

    public Libri() {
        super();
    }

    public Libri(Long id, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere, String isbn) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
        this.isbn = isbn;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter e setter per autore e genere
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
}
