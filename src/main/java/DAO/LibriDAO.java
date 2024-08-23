package DAO;

import entities.Libri;
import jakarta.persistence.*;

import java.util.List;

public class LibriDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LibriDAO() {
        emf = Persistence.createEntityManagerFactory("catalogobiblioteca");
        em = emf.createEntityManager();
    }

    public void addCatalogoBiblioteca(Libri libro) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public List<Libri> getLibriByAutore(String autore) {
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore", Libri.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
