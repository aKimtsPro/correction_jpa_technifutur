package bstorm.akimts.correction_jpa.metier.service.spec;

import bstorm.akimts.correction_jpa.models.dtos.HotelDTO;
import bstorm.akimts.correction_jpa.models.forms.HotelInsertForm;
import bstorm.akimts.correction_jpa.models.forms.HotelUpdateForm;

import java.util.List;

public interface HotelService {

    // CREATE
    HotelDTO insert(HotelInsertForm form);

    // READ
    HotelDTO getOne(Long id);
    List<HotelDTO> getAll();

    // UPDATE
    HotelDTO update( Long id, HotelUpdateForm form );

    // DELETE
    HotelDTO delete ( Long id );

    // Autres
    List<HotelDTO> getAvecMinEtoile( byte nbrEtoile );
    HotelDTO updateGerant(Long id, Long gerantId);

}
