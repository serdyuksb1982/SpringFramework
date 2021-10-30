package com.serdyuk.spring.rest.dao;

import com.serdyuk.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    /**+
     * DAO ответственнен за связь с базой данных
     */
    public void saveEmployee( Employee employee) {

        Session session = sessionFactory.getCurrentSession();
        /**+
         * метод .saveOrUpdate проверяет id работника, если
         * id = 0, то insert new Employee, если
         * id != 0, то update по id
         */
        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
