package bstorm.akimts.correction_jpa.models.dtos;

import bstorm.akimts.correction_jpa.models.entities.Chambre;
import bstorm.akimts.correction_jpa.models.entities.Gerant;
import bstorm.akimts.correction_jpa.models.entities.Hotel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelDTO implements Serializable {
    private final Long id;
    private final String nom;
    private final String adresse;
    private final byte etoiles;
    private final GerantDTO gerant;
    private final List<ChambreDTO> chambres;

    public static HotelDTO of(Hotel entity){
        if( entity == null )
            return null;

        return new HotelDTO(
                entity.getId(),
                entity.getNom(),
                entity.getAdresse(),
                entity.getNbrEtoile(),
                GerantDTO.of(entity.getGerant()),
                entity.getChambres() == null ? null : entity.getChambres().stream()
                        .map(ChambreDTO::of)
                        .toList()
        );
    }

    @Data
    public static class ChambreDTO{
        private final int numChambre;
        private final float prix;

        public static ChambreDTO of(Chambre entity){

            if(entity == null)
                return null;

            return new ChambreDTO(entity.getNumChambre(), entity.getPrix());
        }
    }

    @Data
    public static class GerantDTO{
        private final Long id;
        private final String nom;

        public static GerantDTO of(Gerant entity){
            if(entity == null)
                return null;

            return new GerantDTO(entity.getId(), entity.getNom());
        }
    }




}
