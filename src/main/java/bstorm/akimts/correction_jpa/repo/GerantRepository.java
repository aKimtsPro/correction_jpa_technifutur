package bstorm.akimts.correction_jpa.repo;

import bstorm.akimts.correction_jpa.entities.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository extends JpaRepository<Gerant, Long> {
}