package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

//    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/add/employee")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

}
