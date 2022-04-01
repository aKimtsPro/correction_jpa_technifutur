package bstorm.akimts.correction_jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @Column(name = "num_chambre", nullable = false)
    private int numChambre;

    @Column(name = "nbr_etoiles")
    private Integer nbrEtoiles;

    @Column(name = "nom", nullable = false, unique = true, length = 50)
    private String nom;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @ManyToMany
    private List<Client> clients = new ArrayList<>();

    @ManyToOne
    private Hotel hotel;

}