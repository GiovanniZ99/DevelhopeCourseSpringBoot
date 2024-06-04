package co.develhope.checkpoint.services;

import co.develhope.checkpoint.entities.Employee;
import co.develhope.checkpoint.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));
    }
}

