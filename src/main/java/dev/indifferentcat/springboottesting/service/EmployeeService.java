package dev.indifferentcat.springboottesting.service;

import dev.indifferentcat.springboottesting.model.Employee;
import dev.indifferentcat.springboottesting.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee) {
        Optional<Employee> savedEmployee = employeeRepository.findByEmail(employee.getEmail());

        if (savedEmployee.isPresent()) {
            throw new RuntimeException("Employee with email already exists!");
        }
        return employeeRepository.save(employee);
    }



}
