package dev.indifferentcat.springboottesting.repository;

import dev.indifferentcat.springboottesting.model.Employee;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Employee must be saved and returned")
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
        Employee employee = Employee.builder()
                .email("neilryanlipaod@gmail.com")
                .firstName("Neil Ryan")
                .lastName("Lipa-od")
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
        assertThat(savedEmployee).isEqualTo(employee);


    }

}