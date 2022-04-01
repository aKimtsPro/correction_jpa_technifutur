package bstorm.akimts.correction_jpa.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @NonNull
    @Column(name = "num_chambre", nullable = false)
    private int numChambre;

    @NonNull
    @Column(nullable = false)
    private boolean aTele;

    @NonNull
    @Column(nullable = false)
    private boolean aCuisine;

    @NonNull
    @Column(name = "a_minibar", nullable = false)
    private boolean aMiniBar;

    @NonNull
    @Column(nullable = false, precision = 2)
    private float prix;

    @ManyToMany
    @JoinTable(
            name = "visite",
            joinColumns = @JoinColumn(name = "chambre_id"),
            inverseJoinColumns = @JoinColumn(name = "visiteur_id"),
            uniqueConstraints = @UniqueConstraint(
                    name = "UNIK_visiteur_chambre",
                    columnNames = { "chambre_id", "visiteur_id" }
            )
    )
    private List<Client> clients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

}