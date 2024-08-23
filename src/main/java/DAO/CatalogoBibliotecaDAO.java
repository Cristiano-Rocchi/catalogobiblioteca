package DAO;

import entities.CatalogoBiblioteca;
import entities.Libri;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class CatalogoBibliotecaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CatalogoBibliotecaDAO(EntityManager em) {
        this.em = em;
        this.emf = null;
    }

    public void addCatalogoBiblioteca(CatalogoBiblioteca catalogo) {
        em.getTransaction().begin();
        em.persist(catalogo);
        em.getTransaction().commit();
    }

    public List<Libri> getLibriByAutore(String autore) {
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore", Libri.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Libri> getLibriByAnnoPubblicazione(LocalDate annoPubblicazione) {
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.annoPubblicazione = :annoPubblicazione", Libri.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }

    public List<Libri> getLibriByTitolo(String titolo) {
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.titolo LIKE :titolo", Libri.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}
