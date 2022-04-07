package bstorm.akimts.correction_jpa.utils;

import bstorm.akimts.correction_jpa.data.repo.GerantRepository;
import bstorm.akimts.correction_jpa.data.repo.HotelRepository;
import bstorm.akimts.correction_jpa.data.repo.UserRepository;
import bstorm.akimts.correction_jpa.models.entities.Gerant;
import bstorm.akimts.correction_jpa.models.entities.Hotel;
import bstorm.akimts.correction_jpa.models.entities.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final HotelRepository repository;
    private final GerantRepository gRepo;
    private final UserRepository uRepo;
    private final PasswordEncoder encoder;

    public DatabaseFiller(HotelRepository repository, GerantRepository gRepo, UserRepository uRepo, PasswordEncoder encoder) {
        this.repository = repository;
        this.gRepo = gRepo;
        this.uRepo = uRepo;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setupHotelGerant();

        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("pass"));
        user.setRoles(List.of("ROLE_USER"));

        uRepo.save(user);
    }

    private void setupHotelGerant(){
        Gerant g = Gerant.builder()
                .debutCarriere(LocalDate.now())
                .prenom("luc")
                .nom("dubois")
                .build();
        gRepo.save(g);

        Hotel h = Hotel.builder()
                .nom("Great Nothern")
                .adresse("0 rue null")
//                .gerant(g)
                .nbrEtoile((byte)1)
                .build();
        repository.save(h);

        g = Gerant.builder()
                .debutCarriere(LocalDate.now().minusDays(2))
                .prenom("marie")
                .nom("desmet")
                .build();
        g = gRepo.save(g);

        h = Hotel.builder()
                .nom("Grand Budapest")
                .adresse("0 rue null")
                .gerant(g)
                .nbrEtoile((byte)3)
                .build();

        repository.save(h);
    }
}
