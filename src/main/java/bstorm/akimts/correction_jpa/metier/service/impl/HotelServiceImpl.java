package bstorm.akimts.correction_jpa.metier.service.impl;

import bstorm.akimts.correction_jpa.data.repo.GerantRepository;
import bstorm.akimts.correction_jpa.data.repo.HotelRepository;
import bstorm.akimts.correction_jpa.exceptions.ElementNotFoundException;
import bstorm.akimts.correction_jpa.metier.service.spec.HotelService;
import bstorm.akimts.correction_jpa.models.dtos.GerantDTO;
import bstorm.akimts.correction_jpa.models.dtos.HotelDTO;
import bstorm.akimts.correction_jpa.models.entities.Gerant;
import bstorm.akimts.correction_jpa.models.entities.Hotel;
import bstorm.akimts.correction_jpa.models.forms.HotelInsertForm;
import bstorm.akimts.correction_jpa.models.forms.HotelUpdateForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;
    private final GerantRepository gRepo;

    public HotelServiceImpl(HotelRepository repository, GerantRepository gRepo) {
        this.repository = repository;
        this.gRepo = gRepo;
    }

    @Override
    public HotelDTO insert(HotelInsertForm form) {
        Hotel entity = form.toEntity();
        if(form.getGerantId() != null)
            entity.setGerant(
                    gRepo.findById(form.getGerantId())
                            .orElseThrow(() -> new ElementNotFoundException(form.getGerantId(), Gerant.class))
            );

        return HotelDTO.of( repository.save(entity) );
    }

    @Override
    public HotelDTO getOne(Long id) {
        return repository.findById(id)
                .map(HotelDTO::of)
                .orElseThrow(() -> new ElementNotFoundException(id, Hotel.class));
    }

    @Override
    public List<HotelDTO> getAll() {
        return repository.findAll().stream()
                .map(HotelDTO::of)
                .toList();
    }

    @Override
    public HotelDTO update(Long id, HotelUpdateForm form) {
        Hotel entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Hotel.class));

        entity.setNom(form.getNom());
        entity.setAdresse(form.getAdresse());
        entity.setNbrEtoile(form.getNbrEtoiles());

        return HotelDTO.of( repository.save(entity) );
    }

    @Override
    public HotelDTO delete(Long id) {
        HotelDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }

    @Override
    public List<HotelDTO> getAvecMinEtoile(byte nbrEtoile) {
        return repository.findMinEtoile(nbrEtoile).stream()
                .map(HotelDTO::of)
                .toList();

//        return repository.findByNbrEtoileGreaterThanEqual(nbrEtoile).stream()
//                .map(HotelDTO::of)
//                .toList();

//        return repository.findAll()
//                .stream()
//                .filter( e -> e.getNbrEtoile() >= nbrEtoile )
//                .map(HotelDTO::of)
//                .toList();
    }

    @Override
    public HotelDTO updateGerant(Long id, Long gerantId) {
//
//        if(repository.existsById(id)) {
//
//            if(gRepo.existsById(gerantId)){
//
//                repository.updateGerant(id, gerantId);
//                return repository.findById(id)
//                        .map(HotelDTO::of)
//                        .orElseThrow(() -> new ElementNotFoundException(id, Hotel.class));
//
//            }
//            throw new ElementNotFoundException(gerantId, Gerant.class);
//        }
//        throw new ElementNotFoundException(id, Hotel.class);

        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Hotel.class));
        Gerant gerant = gRepo.findById(gerantId)
                .orElseThrow(() -> new ElementNotFoundException(gerantId, Gerant.class));

        hotel.setGerant(gerant);

        return HotelDTO.of( repository.save(hotel) );
    }
}
