package com.serdyuk.spring.springboot.spring_springboot.dao;


import com.serdyuk.spring.springboot.spring_springboot.entity.Employee;
/*import org.hibernate.Session;
import org.hibernate.query.Query;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
/**+
 * @Repository - это специализированный @Component.
 * Данная аннотация используется для DAO.
 * При поиске компонентов, Spring также будет
 * регистрировать все DAO с аннотацией @Repository в Spring Container-e
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    /**+
     * вместо SessionFactory в SpringBoot используют EntityManager
     */
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee() {

        /**+
         * реализация без Hibernate, а с помощью JPA
         */
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    /**+
     * DAO ответственнен за связь с базой данных
     */
    public void saveEmployee( Employee employee) {

        /**+
         * Метод JPA merge соответствует методу saveOrUpdate в Hibernate
         */
        Employee newEmployee = entityManager.merge(employee);

        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {

        /**+
         * На основе JPA с помощью метода find
         */
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        /**+
         * С помощью JPA с использованием entityManager
         */
        Query query = entityManager.createQuery("delete from Employee " +
                "where id =:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
