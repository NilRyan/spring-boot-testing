package dev.indifferentcat.springboottesting.service;

import dev.indifferentcat.springboottesting.model.Employee;
import dev.indifferentcat.springboottesting.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.Optional;

class EmployeeServiceTest {

    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnSavedEmployeeObject() {
        // given
        Employee employee = Employee.builder()
                .email("neilryan@gmail.com")
                .firstName("Neil")
                .lastName("Ryan")
                .build();
        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        // when
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // then
        Assertions.assertThat(savedEmployee).isEqualTo(employee);



    }
}