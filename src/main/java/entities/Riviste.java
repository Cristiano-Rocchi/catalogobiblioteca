package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

enum Periodicita {
    MENSILE, SETTIMANALE, GIORNALIERO
}

@Entity
@Table(name = "riviste")
public class Riviste extends CatalogoBiblioteca {

    @Enumerated(EnumType.STRING)
    private Periodicita tipoEvento;

    public Riviste(Long id, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicita tipoEvento) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.tipoEvento = tipoEvento;
    }

    public Periodicita getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Periodicita tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}




