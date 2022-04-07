package bstorm.akimts.correction_jpa.models.forms;

import lombok.Data;

@Data
public class HotelUpdateForm {

    private String nom;
    private String adresse;
    private byte nbrEtoiles;

}
