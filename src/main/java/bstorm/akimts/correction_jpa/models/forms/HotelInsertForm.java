package bstorm.akimts.correction_jpa.models.forms;

import bstorm.akimts.correction_jpa.models.entities.Hotel;
import lombok.Data;

@Data
public class HotelInsertForm {

    private String nom;
    private String adresse;
    private byte nbrEtoiles;
    private Long gerantId;

    /**
     * Mappe le formulaire HotelInsertForm en entity Hotel.
     * Ne mappe pas le gérant.
     *
     * @return un Hotel (le gérant n'est pas défini)
     */
    public Hotel toEntity(){
        return Hotel.builder()
                .nom(getNom())
                .adresse(getAdresse())
                .nbrEtoile(getNbrEtoiles())
                .build();
    }

}
