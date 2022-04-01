package bstorm.akimts.correction_jpa.data.repo;

import bstorm.akimts.correction_jpa.models.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
}