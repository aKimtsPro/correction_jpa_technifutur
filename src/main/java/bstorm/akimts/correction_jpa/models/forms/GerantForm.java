package bstorm.akimts.correction_jpa.models.forms;

import lombok.*;

import java.time.LocalDate;

@Data
public class GerantForm {

    private String nom;
    private String prenom;
    private LocalDate debutCarriere;

}
