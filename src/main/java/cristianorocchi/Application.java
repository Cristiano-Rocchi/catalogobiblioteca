package cristianorocchi;

import DAO.LibriDAO;
import entities.Libri;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LibriDAO libriDAO = new LibriDAO();

        try {
            // Aggiungere 10 libri
            for (int i = 1; i <= 10; i++) {
                Libri libro = new Libri(
                        null, //
                        "Titolo Libro " + i,
                        LocalDate.of(2020, 1, 1),
                        100 + i,
                        "Autore " + i,
                        "Genere " + (i % 3),
                        "ISBN" + i
                );
                libriDAO.addCatalogoBiblioteca(libro);
            }

            // ricera per autore
            List<Libri> libriTrovati = libriDAO.getLibriByAutore("Autore 1");
            for (Libri libro : libriTrovati) {
                System.out.println("Libro trovato: " + libro.getTitolo());
            }
        } finally {
            libriDAO.close();
        }
    }
}
