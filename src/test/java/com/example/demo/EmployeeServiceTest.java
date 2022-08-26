package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class EmployeeServiceTest {
    EmployeeRepository employeeRepository;
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void testGetEmployee() {
        Employee employee = new Employee();
        Mockito.when(employeeRepository.findById("1"))
                .thenReturn(Optional.of(employee));
        Employee resultantEmployee = employeeService.getEmployee("1");
        Assertions.assertNotNull(resultantEmployee);
        Assertions.assertEquals(employee, resultantEmployee);
    }

    @Test
    void testGetEmployee_notFound() {
        Mockito.when(employeeRepository.findById("1"))
                .thenReturn(Optional.empty());
        Employee resultantEmployee = employeeService.getEmployee("1");
        Assertions.assertNull(resultantEmployee);
    }

}
