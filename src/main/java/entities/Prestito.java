package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestito")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private CatalogoBiblioteca elementoPrestato;

    @Column(name = "data_inizio_prestito")
    private Date dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private Date dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private Date dataRestituzioneEffettiva;

    // Getters e Setters
}
