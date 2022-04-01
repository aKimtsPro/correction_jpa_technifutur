package bstorm.akimts.correction_jpa.data.repo;

import bstorm.akimts.correction_jpa.models.entities.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository extends JpaRepository<Gerant, Long> {
}