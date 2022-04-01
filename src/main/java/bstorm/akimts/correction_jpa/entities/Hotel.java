package bstorm.akimts.correction_jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nbr_etoiles", columnDefinition = "INT NOT NULL CHECK (nbr_etoiles BETWEEN 1 AND 5)")
    private byte nbrEtoile;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "adresse", columnDefinition = "VARCHAR(200) DEFAULT 'inconnu'", insertable = false, nullable = false)
    private String adresse;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
    private List<Chambre> chambres = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_HOTEL_GERANT_ID") )
    private Gerant gerant;
}