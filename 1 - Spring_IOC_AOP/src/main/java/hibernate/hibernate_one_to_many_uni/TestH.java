package hibernate.hibernate_one_to_many_uni;



import hibernate.hibernate_one_to_many_uni.entity.Department;
import hibernate.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestH {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()){
                /**+
                 * Добавление в таблицы Employee и Departments информации UNI-directional
                 */
                /*Department dep = new Department("Hr", 1500, 500);
                Employee emp_1 = new Employee("Oleg", "Ivanov",  800);
                Employee emp_2 = new Employee("Andrey", "Sidorov", 1000);
                dep.addEmployeeToDepartment(emp_1);
                dep.addEmployeeToDepartment(emp_2);
                session.beginTransaction();
                session.save(dep);
                session.getTransaction().commit();
                System.out.println("Done!");*/
                /**+
                 * Получение данных из таблицы
                 */
                /*session.beginTransaction();
                Department department = session.get(Department.class, 1);
                System.out.println(department);
                System.out.println(department.getEmps());
                session.getTransaction().commit();
                System.out.println("Done!");*/
                /**+
                 * Вариант с удалением
                 */
                session.beginTransaction();
                Department dep1 = session.get(Department.class, 2);
                session.delete(dep1);
                session.getTransaction().commit();
                System.out.println("Done!");
            }
        }
    }
}
