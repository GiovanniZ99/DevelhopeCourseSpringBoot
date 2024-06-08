package co.develhope.CustomQueries_es.controllers;

import co.develhope.CustomQueries_es.entities.Flight;
import co.develhope.CustomQueries_es.enums.Status;
import co.develhope.CustomQueries_es.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @PostMapping("/provision")
    public List<Flight> provisionFlights() {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, 50)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Flight " + random.ints(48, 123)
                            .filter(num -> (num < 58 || num > 64) && (num < 91 || num > 96))
                            .limit(10)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString());
                    flight.setFromAirport("Airport " + random.ints(65, 91)
                            .limit(3)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString());
                    flight.setToAirport("Airport " + random.ints(65, 91)
                            .limit(3)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString());
                    flight.setStatus(Status.ONTIME);
                    return flight;
                })
                .collect(Collectors.toList());
        return flightRepository.saveAll(flights);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/description")
    public List<Flight> getFlightsByDescription(@RequestParam String description) {
        return flightRepository.findByDescription(description);
    }

    @GetMapping("/fromAirport")
    public List<Flight> getFlightsByFromAirport(@RequestParam String fromAirport) {
        return flightRepository.findByFromAirport(fromAirport);
    }

    @GetMapping("/toAirport")
    public List<Flight> getFlightsByToAirport(@RequestParam String toAirport) {
        return flightRepository.findByToAirport(toAirport);
    }

    @GetMapping("/status")
    public List<Flight> getFlightsByStatus(@RequestParam Status status) {
        return flightRepository.findByStatus(status);
    }
}

