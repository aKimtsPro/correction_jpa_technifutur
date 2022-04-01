package bstorm.akimts.correction_jpa.metier.service;

import bstorm.akimts.correction_jpa.models.dtos.GerantDTO;
import bstorm.akimts.correction_jpa.models.forms.GerantForm;

import java.util.List;

public interface GerantService {

    // CREATE
    public GerantDTO insert(GerantForm form);

    // READ
    public GerantDTO getOne(Long id);
    public List<GerantDTO> getAll();

    // UPDATE
    public GerantDTO update( Long id, GerantForm form );

    // DELETE
    public GerantDTO delete ( Long id );

}
