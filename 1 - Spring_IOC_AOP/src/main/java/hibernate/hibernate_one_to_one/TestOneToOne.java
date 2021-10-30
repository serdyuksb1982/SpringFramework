package hibernate.hibernate_one_to_one;

import hibernate.hibernate_one_to_one.entity.Detail;
import hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()){
            try (Session session = factory.getCurrentSession()){
                /**+
                 * добавление в таблицу Bi-directional отношений, это когда обе стороны знают друг о друге
                 */
                /*Employee employee = new Employee("Анна", "Сердюк", "Школа", 1000);
                Detail detail = new Detail("Москва", "89253736771", "anya@mail.ru");
                employee.setEmpDetail(detail);
                detail.setEmployee(employee);
                session.beginTransaction();
                session.save(detail);*/
                /**+
                 *вывод данных из Employee на основе Detail
                 */
                /*session.beginTransaction();
                Detail detail = session.get(Detail.class, 3);
                System.out.println(detail.getEmployee());*/
                /**+
                 * удаление из Employee на основании Detail
                 */
                session.beginTransaction();
                Detail detail = session.get(Detail.class, 1);
                detail.getEmployee().setEmpDetail(null);
                session.delete(detail);

                session.getTransaction().commit();

                System.out.println("Done!");
            }

        }
    }
}
