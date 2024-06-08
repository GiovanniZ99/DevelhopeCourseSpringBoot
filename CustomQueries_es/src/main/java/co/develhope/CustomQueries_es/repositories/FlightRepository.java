package co.develhope.CustomQueries_es.repositories;

import co.develhope.CustomQueries_es.entities.Flight;
import co.develhope.CustomQueries_es.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDescription(String description);
    List<Flight> findByFromAirport(String fromAirport);
    List<Flight> findByToAirport(String toAirport);
    List<Flight> findByStatus(Status status);
}
