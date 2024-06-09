package co.develhope.CustomQueries_es1.repositories;
import co.develhope.CustomQueries_es1.entities.Flight;
import co.develhope.CustomQueries_es1.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    String findDescriptionById(Long id);
    String findFromAirportById(Long id);
    String findToAirportById(Long id);
    Status findStatusById(Long id);
    List<Flight> findByDescriptionContaining(String keyword);
}
