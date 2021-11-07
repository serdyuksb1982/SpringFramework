package com.serdyuk.spring.springboot.spring_springboot.service;



import com.serdyuk.spring.springboot.spring_springboot.dao.EmployeeDAO;
import com.serdyuk.spring.springboot.spring_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
/**+
 * Аннотация @Service отмечает класс, содержащий бизнесс-логику.
 * В иерархии компонентов приложения Service является соединительным звеном между Controller-ом и DAO
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    /**+
     * аннотация @Transactional передает Spring управление транзакциями
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeDAO.getAllEmployee();
        return employeeList;
    }

    @Override
    @Transactional
    public void saveEmployee( Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    public EmployeeServiceImpl() {
    }
}
