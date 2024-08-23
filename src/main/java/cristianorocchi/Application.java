package cristianorocchi;

import DAO.LibriDAO;
import entities.Libri;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LibriDAO libriDAO = new LibriDAO();

        try {
            // Aggiungo 10 libri
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
                libriDAO.addCatalogoBiblioteca(libro);
            }

            // Ricerca per autore
            List<Libri> libriTrovatiAutore = libriDAO.getLibriByAutore("Autore 1");
            for (Libri libro : libriTrovatiAutore) {
                System.out.println("Libro trovato per autore: " + libro.getTitolo());
            }

            // Ricerca per anno
            LocalDate annoPubblicazione = LocalDate.of(2020, 1, 1);
            List<Libri> libriTrovatiAnno = libriDAO.getLibriByAnnoPubblicazione(annoPubblicazione);
            for (Libri libro : libriTrovatiAnno) {
                System.out.println("Libro trovato per anno di pubblicazione: " + libro.getTitolo());
            }

        } finally {
            libriDAO.close();
        }
    }
}
