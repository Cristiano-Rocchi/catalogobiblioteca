package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "libri")
public class Libri extends CatalogoBiblioteca {

    private String autore;
    private String genere;

    // Getters e Setters
}

