package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "riviste")
public class Riviste extends CatalogoBiblioteca {

    private boolean periodicita;

    // Getters e Setters
}

