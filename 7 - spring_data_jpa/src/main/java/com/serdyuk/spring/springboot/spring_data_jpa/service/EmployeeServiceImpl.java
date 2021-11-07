package com.serdyuk.spring.springboot.spring_data_jpa.service;




import com.serdyuk.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.serdyuk.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
/**+
 * Аннотация @Service отмечает класс, содержащий бизнесс-логику.
 * В иерархии компонентов приложения Service является соединительным звеном между Controller-ом и DAO
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee( Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;

        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }

    @Override
    public List<Employee> findAllByLastname(String lastname) {
        List<Employee> employees = employeeRepository.findAllByLastname(lastname);
        return employees;
    }

    @Override
    public List<Employee> findAllBySurname(String surname) {
        List<Employee> employees = employeeRepository.findAllBySurname(surname);

        return employees;
    }

    @Override
    public List<Employee> findAllByDepartment(String department) {
        List<Employee> employees = employeeRepository.findAllByDepartment(department);
        return employees;
    }

}
