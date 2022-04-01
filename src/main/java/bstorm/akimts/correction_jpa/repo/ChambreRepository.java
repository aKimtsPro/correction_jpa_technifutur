package bstorm.akimts.correction_jpa.repo;

import bstorm.akimts.correction_jpa.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
}