package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.MyConfig;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigAOP.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = uniLibrary.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);
        context.close();
        System.out.println("Method main ends");
    }
}