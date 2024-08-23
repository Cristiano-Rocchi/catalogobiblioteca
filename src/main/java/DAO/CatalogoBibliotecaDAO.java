package DAO;

import entities.CatalogoBiblioteca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CatalogoBibliotecaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CatalogoBibliotecaDAO() {
        emf = Persistence.createEntityManagerFactory("catalogobiblioteca");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void addCatalogoBiblioteca(CatalogoBiblioteca catalogo) {
        em.getTransaction().begin();
        em.persist(catalogo);
        em.getTransaction().commit();
    }

    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}
