package bstorm.akimts.correction_jpa.data.repo;

import bstorm.akimts.correction_jpa.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}