package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "riviste")
public class Riviste extends CatalogoBiblioteca {

    private boolean periodicita;

    public Riviste(Long id, String titolo, Date annoPubblicazione, int numeroPagine) {
        super(id, titolo, annoPubblicazione, numeroPagine);
    }

    public Riviste(Long id, String titolo, Date annoPubblicazione, int numeroPagine, boolean periodicita) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}

