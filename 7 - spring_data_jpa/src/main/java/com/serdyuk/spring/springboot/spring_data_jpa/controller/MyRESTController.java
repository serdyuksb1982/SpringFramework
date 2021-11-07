package com.serdyuk.spring.springboot.spring_data_jpa.controller;



import com.serdyuk.spring.springboot.spring_data_jpa.entity.Employee;
import com.serdyuk.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;

    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee.getId());
        return "Employee with Id = " + id + " was deleted.";

    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findAllByName(name);
        return employees;
    }

    @GetMapping("/employees/lastname/{lastname}")
    public List<Employee> showAllEmployeesByLastname(@PathVariable String lastname) {
        List<Employee> employees = employeeService.findAllByLastname(lastname);
        return employees;
    }

    @GetMapping("/employees/surname/{surname}")
    public List<Employee> showAllEmployeesBySurname(@PathVariable String surname) {
        List<Employee> employees = employeeService.findAllBySurname(surname);
        return employees;
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> showAllEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.findAllByDepartment(department);
        return employees;
    }

}
