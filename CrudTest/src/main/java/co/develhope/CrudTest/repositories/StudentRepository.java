package co.develhope.CrudTest.repositories;

import co.develhope.CrudTest.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByCodiceFiscale(String codiceFiscale);
}
