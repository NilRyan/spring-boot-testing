package dev.indifferentcat.springboottesting.service;

import dev.indifferentcat.springboottesting.model.Employee;
import dev.indifferentcat.springboottesting.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .email("neilryan@gmail.com")
                .firstName("Neil")
                .lastName("Ryan")
                .build();
    }

    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnSavedEmployeeObject() {
        // given
        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
        given(employeeRepository.save(employee)).willReturn(employee);

        // when
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // then
        assertThat(savedEmployee).isEqualTo(employee);



    }
}