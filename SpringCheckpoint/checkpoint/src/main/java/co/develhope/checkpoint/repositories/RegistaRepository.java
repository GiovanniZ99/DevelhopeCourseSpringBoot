package co.develhope.checkpoint.repositories;

import co.develhope.checkpoint.entities.Regista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface RegistaRepository extends JpaRepository<Regista, Long> {
}
