package bstorm.akimts.correction_jpa.repo;

import bstorm.akimts.correction_jpa.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}