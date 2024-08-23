package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "libri")
public class Libri extends CatalogoBiblioteca {

    private String autore;
    private String genere;

    public Libri(Long id, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        super(id, titolo, annoPubblicazione, numeroPagine);
    }


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

