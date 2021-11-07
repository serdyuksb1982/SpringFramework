package com.serdyuk.spring.springboot.spring_springboot.controller;


import com.serdyuk.spring.springboot.spring_springboot.entity.Employee;
import com.serdyuk.spring.springboot.spring_springboot.service.EmployeeService;
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

    /**+
     * @param id аннотация @PathVarieble используется для получения
     * значения переменной из адреса запроса
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    /**+
     * Аннотация @RequestBody связывает тело HTTP метода с
     * параметром метода Controller-a
     */
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

}
