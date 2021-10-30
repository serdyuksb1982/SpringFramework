package aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstactLibrary {


    public void getBook() {
        System.out.println("We take the book from SchoolLibrary. ");
    }


    public void returnBook(int num) {
        System.out.println("We return the book from SchoolLibrary. ");
    }
}
