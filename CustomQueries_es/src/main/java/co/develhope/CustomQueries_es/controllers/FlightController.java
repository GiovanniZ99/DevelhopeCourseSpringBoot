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
        List<Flight> flights = IntStream.range(0, 50).mapToObj(i -> {
            Flight flight = new Flight();
            flight.setDescription("Description " + random.ints(48, 122).limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            flight.setFromAirport("FromAirport " + random.ints(48, 122).limit(3)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            flight.setToAirport("ToAirport " + random.ints(48, 122).limit(3)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            flight.setStatus(Status.ONTIME);
            return flight;
        }).collect(Collectors.toList());

        return flightRepository.saveAll(flights);
    }
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/description/{id}")
    public String getDescription(@PathVariable Long id) {
        return flightRepository.findDescriptionById(id);
    }

    @GetMapping("/from-airport/{id}")
    public String getFromAirport(@PathVariable Long id) {
        return flightRepository.findFromAirportById(id);
    }

    @GetMapping("/to-airport/{id}")
    public String getToAirport(@PathVariable Long id) {
        return flightRepository.findToAirportById(id);
    }

    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable Long id) {
        return flightRepository.findStatusById(id);
    }

    @GetMapping("/search")
    public List<Flight> searchByDescription(@RequestParam String keyword) {
        return flightRepository.findByDescriptionContaining(keyword);
    }
}
