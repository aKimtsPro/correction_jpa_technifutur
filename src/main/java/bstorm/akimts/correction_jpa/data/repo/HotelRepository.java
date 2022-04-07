package bstorm.akimts.correction_jpa.data.repo;

import bstorm.akimts.correction_jpa.models.entities.Gerant;
import bstorm.akimts.correction_jpa.models.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByNbrEtoileGreaterThanEqual( byte minEtoile );

    @Query("SELECT h FROM Hotel h WHERE h.nbrEtoile >= ?1")
    List<Hotel> findMinEtoile( byte minEtoile );

    @Modifying @Transactional
    @Query(value = "UPDATE Hotel SET manager_id = ?2 WHERE id = ?1", nativeQuery = true)
    void updateGerant(Long idHotel, Long idGerant);

}