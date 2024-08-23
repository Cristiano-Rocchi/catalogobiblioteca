package cristianorocchi;

import DAO.CatalogoBibliotecaDAO;
import entities.Libri;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobiblioteca");
        EntityManager em = emf.createEntityManager();
        CatalogoBibliotecaDAO catalogoDAO = new CatalogoBibliotecaDAO(em);

        try {
            for (int i = 1; i <= 10; i++) {
                Libri libro = new Libri(
                        null,
                        "Titolo Libro " + i,
                        LocalDate.of(2020, 1, 1),
                        100 + i,
                        "Autore " + i,
                        "Genere " + (i % 3),
                        "ISBN" + i
                );
                catalogoDAO.addCatalogoBiblioteca(libro);
            }

            List<Libri> libriTrovatiAutore = catalogoDAO.getLibriByAutore("Autore 1");
            for (Libri libro : libriTrovatiAutore) {
                System.out.println("Libro trovato per autore: " + libro.getTitolo());
            }

            LocalDate annoPubblicazione = LocalDate.of(2020, 1, 1);
            List<Libri> libriTrovatiAnno = catalogoDAO.getLibriByAnnoPubblicazione(annoPubblicazione);
            for (Libri libro : libriTrovatiAnno) {
                System.out.println("Libro trovato per anno di pubblicazione: " + libro.getTitolo());
            }

            List<Libri> libriTrovatiTitolo = catalogoDAO.getLibriByTitolo("Libro 1");
            for (Libri libro : libriTrovatiTitolo) {
                System.out.println("Libro trovato per titolo: " + libro.getTitolo());
            }

        } finally {
            catalogoDAO.close();
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
