package com.serdyuk.spring.rest.controller;
import com.serdyuk.spring.rest.entity.Employee;
import com.serdyuk.spring.rest.exception_handling.NoSuchEmployeeException;
import com.serdyuk.spring.rest.service.EmployeeService;
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
        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + "int Database");
        }

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
        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + "int Database");
        } else {
            employeeService.deleteEmployee(id);
            String result = "Employee with ID = " + id + " was deleted";
            return result;
        }

    }

}
