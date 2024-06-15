package co.develhope.CustomQueries_es2.repositories;

import co.develhope.CustomQueries_es2.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {

    List<Flight> findByStatus(String status);

    List<Flight> findByStatusIn(List<String> statuses);

    Page<Flight> findAllByOrderByFromAirportAsc(Pageable pageable);
}
