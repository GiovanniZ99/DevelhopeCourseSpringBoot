package co.develhope.CustomQueries_es2.controllers;

import co.develhope.CustomQueries_es2.entities.Flight;
import co.develhope.CustomQueries_es2.enums.Status;
import co.develhope.CustomQueries_es2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @GetMapping("/provision")
    public ResponseEntity<List<Flight>> provisioningFlights(@RequestParam Optional<Integer> n) {
        int nFlights = n.orElse(100);
        Random random = new Random();

        List<Flight> flights = IntStream.range(0, nFlights)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Description " + random.ints(48, 122).limit(10)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
                    flight.setFromAirport("FromAirport " + random.ints(48, 122).limit(3)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
                    flight.setToAirport("ToAirport " + random.ints(48, 122).limit(3)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
                    flight.setStatus(getRandomStatus(random));
                    return flight;
                })
                .collect(Collectors.toList());

        List<Flight> savedFlights = flightRepository.saveAll(flights);

        return ResponseEntity.ok(savedFlights);
    }

    private Status getRandomStatus(Random random) {
        Status[] statusArray = {Status.valueOf("ONTIME"), Status.valueOf("DELAYED"), Status.valueOf("CANCELLED")};
        return statusArray[random.nextInt(statusArray.length)];
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightRepository.findAllByOrderByFromAirportAsc();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/ontime")
    public ResponseEntity<List<Flight>> getOnTimeFlights() {
        List<Flight> onTimeFlights = flightRepository.findByStatus("ONTIME");
        return ResponseEntity.ok(onTimeFlights);
    }

    @GetMapping("/bystatus")
    public ResponseEntity<List<Flight>> getFlightsByStatus(@RequestParam("statuses") String[] statuses) {
        List<String> statusList = Arrays.asList(statuses);
        List<Flight> flights = flightRepository.findByStatusIn(statusList);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Flight>> getAllFlightsPaged(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<Flight> flightsPage = flightRepository.findAllByOrderByFromAirportAsc(pageable);
        return ResponseEntity.ok(flightsPage);
    }
}

