package co.develhope.Crud_es.controllers;

import co.develhope.Crud_es.entities.Car;
import co.develhope.Crud_es.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElse(null);
    }

    @PutMapping("/{id}")
    public Car updateCarType(@PathVariable Long id, @RequestParam String type) {
        Car car = carRepository.findById(id).orElse(null);
        car.setType(type);
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}

