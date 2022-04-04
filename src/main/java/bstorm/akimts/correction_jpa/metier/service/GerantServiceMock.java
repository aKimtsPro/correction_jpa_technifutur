package bstorm.akimts.correction_jpa.metier.service;

import bstorm.akimts.correction_jpa.models.dtos.GerantDTO;
import bstorm.akimts.correction_jpa.models.forms.GerantForm;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class GerantServiceMock implements GerantService {
    @Override
    public GerantDTO insert(GerantForm form) {
        return null;
    }

    @Override
    public GerantDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<GerantDTO> getAll() {
        return null;
    }

    @Override
    public GerantDTO update(Long id, GerantForm form) {
        return null;
    }

    @Override
    public GerantDTO delete(Long id) {
        return null;
    }
}
