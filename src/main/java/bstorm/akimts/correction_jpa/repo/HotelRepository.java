package bstorm.akimts.correction_jpa.repo;

import bstorm.akimts.correction_jpa.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}