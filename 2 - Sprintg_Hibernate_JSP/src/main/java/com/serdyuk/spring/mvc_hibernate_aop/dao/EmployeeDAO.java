package com.serdyuk.spring.mvc_hibernate_aop.dao;

import com.serdyuk.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
