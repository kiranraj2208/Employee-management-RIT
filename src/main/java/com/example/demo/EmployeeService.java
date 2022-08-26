package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(String id) {
        return employeeRepository.findById(id)
                .orElse(null);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "success";
    }
}
