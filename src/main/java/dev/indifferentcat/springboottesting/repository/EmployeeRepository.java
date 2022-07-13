package dev.indifferentcat.springboottesting.repository;

import dev.indifferentcat.springboottesting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
