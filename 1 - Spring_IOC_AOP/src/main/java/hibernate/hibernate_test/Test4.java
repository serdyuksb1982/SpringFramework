package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()){
            try (Session session = factory.getCurrentSession()){
                session.beginTransaction();
                session.createQuery("update Employee set salary = 5000 " +
                        "where name = 'Sergey'").executeUpdate();


                session.getTransaction().commit();
                System.out.println("Done!");
            }

        }
    }
}
