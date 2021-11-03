package com.serdyuk.spring.rest;

import com.serdyuk.spring.rest.configuration.MyConfig;
import com.serdyuk.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication"
                , Communication.class);

        /*List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);
        System.out.println("--------------------------------");
        Employee empById = communication.getEmployee(4);
        System.out.println(empById);*/
        /*System.out.println("--------------------------------");
        Employee employee = new Employee("Sveta", "Vasilevna", "Sololova", "HR", 1200, "888-99-11");
        employee.setId(21);
        communication.saveEmployee(employee);*/
        communication.deleteEmployee(21);

    }
}
