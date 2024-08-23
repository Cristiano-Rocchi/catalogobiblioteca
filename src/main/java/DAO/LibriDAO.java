package DAO;

import entities.Libri;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class LibriDAO extends CatalogoBibliotecaDAO {

    public List<Libri> getLibriByAutore(String autore) {
        TypedQuery<Libri> query = getEntityManager().createQuery("SELECT l FROM Libri l WHERE l.autore = :autore", Libri.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Libri> getLibriByAnnoPubblicazione(LocalDate annoPubblicazione) {
        TypedQuery<Libri> query = getEntityManager().createQuery("SELECT l FROM Libri l WHERE l.annoPubblicazione = :annoPubblicazione", Libri.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }

    //  cercare per titolo o in parte
    public List<Libri> getLibriByTitolo(String titolo) {
        TypedQuery<Libri> query = getEntityManager().createQuery("SELECT l FROM Libri l WHERE l.titolo LIKE :titolo", Libri.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }
}
