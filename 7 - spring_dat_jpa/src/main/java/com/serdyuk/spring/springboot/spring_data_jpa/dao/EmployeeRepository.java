package com.serdyuk.spring.springboot.spring_data_jpa.dao;

import com.serdyuk.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**+
 * Spring Data JPA механизм взаимодействия с таблицами баз данных,
 * позволяющий минимизировать кол-во кода.
 * Наследуя JpaRepository, можно использовать набор готовых методов.
 * Так же можно создать свой метод, соблюдая правильное именование метода
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /**+
     * findAll, получение всех работников
     * findById, Получение одного работников
     * save, добавление работника
     * save, изменение работника
     * deleteById удаление работника
     */

    public List<Employee> findAllByName(String name);

    public List<Employee> findAllByLastname(String lastname);

    public List<Employee> findAllBySurname(String surname);

    public List<Employee> findAllByDepartment(String department);
}
