package bstorm.akimts.correction_jpa.utils;

import bstorm.akimts.correction_jpa.entities.Chambre;
import bstorm.akimts.correction_jpa.entities.Hotel;
import bstorm.akimts.correction_jpa.repo.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

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
        h.getChambres().addAll(
                List.of(
                        new Chambre(1,false,false,false, 100),
                        new Chambre(2,false,false,true, 200),
                        new Chambre(3,false,true,false, 300)
                )
        );

        h = repository.save(h);

        h.getChambres().add(new Chambre(4, false,true,true,400));

    }
}
