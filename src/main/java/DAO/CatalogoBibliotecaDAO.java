package DAO;

import entities.CatalogoBiblioteca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CatalogoBibliotecaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CatalogoBibliotecaDAO() {
        emf = Persistence.createEntityManagerFactory("catalogobiblioteca");
        em = emf.createEntityManager();
    }

    public void addCatalogoBiblioteca(CatalogoBiblioteca catalogo) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(catalogo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
