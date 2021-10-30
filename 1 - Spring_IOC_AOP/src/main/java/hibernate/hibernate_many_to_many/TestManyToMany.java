package hibernate.hibernate_many_to_many;
import hibernate.hibernate_many_to_many.entity.Child;
import hibernate.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestManyToMany {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()){
            try (Session session = factory.getCurrentSession()){
                /**+
                 * заполнение трех таблиц Many_to_Many
                 */
                /*Section section_1 = new Section("Dance");
                Child child_1 = new Child("Olya", 12);
                Child child_2 = new Child("Grisha", 8);
                Child child_3 = new Child("Pavel", 9);
                Arrays.asList(child_1,child_2,child_3).forEach(section_1::addChildToSection);
                session.beginTransaction();
                session.persist(section_1);



                session.getTransaction().commit();
                System.out.println("Done!");*/
                //******************************************
                /*Section section_1 = new Section("Volleyball");
                Section section_2 = new Section("Karate");
                Section section_3 = new Section("Math");
                Child child_1 = new Child("Igor", 10);
                Arrays.asList(section_1,section_2,section_3).forEach(child_1::addSectionToChild);
                session.beginTransaction();
                session.save(child_1);
                session.getTransaction().commit();
                System.out.println("Done!");*/
                //******************************************
                /*session.beginTransaction();
                Section section = session.get(Section.class, 1);
                System.out.println(section);
                System.out.println(section.getChildren());
                session.getTransaction().commit();
                System.out.println("Done!");*/
                //******************************************
                /*session.beginTransaction();
                Child child = session.get(Child.class, 3);
                System.out.println(child);
                System.out.println(child.getSections());
                session.getTransaction().commit();
                System.out.println("Done!");*/
                //*******************************************
                /**+
                 * при сascadeType = ALL происходит полное удалениие связанных таблиц
                 */
                session.beginTransaction();
                Child child = session.get(Child.class, 8);
                session.delete(child);
                session.getTransaction().commit();
                System.out.println("Done!");

            }

        }
    }
}
