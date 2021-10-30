package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Dog myDog = context.getBean ( "dog", Dog.class );
        Dog yourDog = context.getBean ( "dog", Dog.class);

        System.out.println ("Переменные ссылаются на один и тот же объект? " + " " + (myDog == yourDog));
        System.out.println (myDog + ", " + yourDog);
        context.close ();*/
        System.out.println("Информация о системе");
        System.out.println(
                "Операционная система: " +
                        System.getProperty("os.name") + " " +
                        System.getProperty("os.version")
        );
        System.out.println(
                "Количество ядер процессора: " +
                        Runtime.getRuntime().availableProcessors()
        );
        System.out.println(
                "Количество памяти, доступной JVM: " +
                        Runtime.getRuntime().maxMemory() / 1024 / 1024 +
                        "Mb"
        );
    }
}
