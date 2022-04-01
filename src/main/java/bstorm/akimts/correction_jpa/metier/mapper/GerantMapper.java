package bstorm.akimts.correction_jpa.metier.mapper;

import bstorm.akimts.correction_jpa.models.dtos.GerantDTO;
import bstorm.akimts.correction_jpa.models.entities.Gerant;
import bstorm.akimts.correction_jpa.models.entities.Hotel;
import bstorm.akimts.correction_jpa.models.forms.GerantForm;
import org.springframework.stereotype.Service;

@Service
public class GerantMapper {

    public GerantDTO entityToDTO(Gerant entity){

        if( entity == null )
            return null;

        Hotel hotelEntity = entity.getGere();
        GerantDTO.HotelDTO hotel = hotelEntity == null ? null :
                new GerantDTO.HotelDTO( hotelEntity.getId(), hotelEntity.getNom() );

        return GerantDTO.builder()
                .id( entity.getId() )
                .nom( entity.getNom() )
                .prenom( entity.getPrenom() )
                .debutCarriere( entity.getDebutCarriere() )
                .hotel( hotel )
                .build();

    }

    public Gerant formToEntity(GerantForm  form) {

        if( form == null )
            return null;

        return  Gerant.builder()
                .nom( form.getNom() )
                .prenom( form.getPrenom() )
                .debutCarriere( form.getDebutCarriere() )
                .build();
    }
}

