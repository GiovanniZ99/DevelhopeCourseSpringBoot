package co.develhope.CustomQueries_es2.repositories;

import co.develhope.CustomQueries_es2.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
    @Query(value = "SELECT * FROM flights ORDER BY from_airport ASC", nativeQuery = true)
    List<Flight> findAllByOrderByFromAirportAsc();

    List<Flight> findByStatus(String status);

    List<Flight> findByStatusIn(List<String> statuses);

    Page<Flight> findAllByOrderByFromAirportAsc(Pageable pageable);
}
