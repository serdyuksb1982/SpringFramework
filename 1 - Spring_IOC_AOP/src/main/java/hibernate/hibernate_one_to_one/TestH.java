package hibernate.hibernate_one_to_one;

import hibernate.hibernate_one_to_one.entity.Detail;
import hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestH {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()){
                /**+
                 * Добавление в таблицы Employee и Detail информации
                 */
                /*Employee employee = new Employee("Oleg", "Unqnovn", "Рога и копыто", 2000);
                Detail employeeDetail = new Detail("Moskov", "8909*****77", "oleg@mail.ru");
                session.beginTransaction();
                employee.setEmpDetail(employeeDetail);
                session.save(employee);*/
                /**+
                 * получение по id из таблицы строчки (с взаимосвязью), при
                 * nullPointerException обеспечить закрытие сессии (лучше в try-с ресурсами)
                 */
                session.beginTransaction();
                Employee emp = session.get(Employee.class, 2);
                /**+
                 * удаление записи по id
                 */
                session.delete(emp);

                session.getTransaction().commit();

                System.out.println("Done!");
            }
        }
    }
}
