package hibernate.hibernate_one_to_many_bi;


import hibernate.hibernate_one_to_many_bi.entity.Department;
import hibernate.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_Loading_Type {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()){
                /**+
                 * Добавление в таблицы Employee и Departments информации
                 */
                /*Department dep = new Department("It", 1200, 300);
                Employee emp_1 = new Employee("Sergey", "Serdyuk",  1000);
                Employee emp_2 = new Employee("Aleksey", "Kiselev", 1200);
                Employee emp_3 = new Employee("Ksenya", "Kiseleva", 500);

                for(Employee employee : Arrays.asList(emp_1, emp_2, emp_3)) {
                    dep.addEmployeeToDepartment(employee);
                }
                session.beginTransaction();
                session.save(dep);
                session.getTransaction().commit();
                System.out.println("DOne!");*/
//**********************************************
                /**+
                 * Получение данных из таблицы Eager FetchType
                 */
                /*session.beginTransaction();
                System.out.println("Get department");
                Department department = session.get(Department.class, 5);
                System.out.println("Show department");
                System.out.println(department);
                System.out.println("Подгрузим работников");
                department.getEmps().get(0);
                session.getTransaction().commit();
                System.out.println("Show employees of the department");
                System.out.println(department.getEmps());
                System.out.println("Done!");*/
//*********************************************
                /**+
                 * Вариант с удалением
                 */
                session.beginTransaction();
                Department emp = session.get(Department.class, 4);
                session.delete(emp);
                session.getTransaction().commit();
                System.out.println("Done!");
//*********************************************

            }
        }
    }
}
