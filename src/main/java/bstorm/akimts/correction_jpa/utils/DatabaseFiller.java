package bstorm.akimts.correction_jpa.utils;

import bstorm.akimts.correction_jpa.entities.Hotel;
import bstorm.akimts.correction_jpa.repo.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean {

    private final HotelRepository repository;

    public DatabaseFiller(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Hotel h = new Hotel();
        h.setNom("mon hotel");
        h.setAdresse("pas inconnu");
        h.setNbrEtoile((byte)4);

        repository.save(h);

    }
}
