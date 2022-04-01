package bstorm.akimts.correction_jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @Column(name = "a_tele", nullable = false)
    private boolean aTele;

    @Column(name = "a_cuisine", nullable = false)
    private boolean aCuisine;

    @Column(name = "a_minibar", nullable = false)
    private boolean aMiniBar;

    @Column(name = "prix", precision = 2, scale = 4)
    private double prix;

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambres;

    @OneToOne
    private Gerant gerant;
}