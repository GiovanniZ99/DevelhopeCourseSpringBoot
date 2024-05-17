package co.develhope.Crud_es.repositories;

import co.develhope.Crud_es.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
