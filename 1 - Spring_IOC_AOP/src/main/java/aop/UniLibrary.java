package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstactLibrary {

    public void getBook() {
        System.out.println("We take the book from UniLibrary");
        System.out.println("--------------------------------");
    }

    public String returnBook() {
        int i = 10 / 0;
        System.out.println("We return the book in UniLibrary.");
        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println("We take the magazine from UniLibrary.");
        System.out.println("--------------------------------");
    }

    public void returnMagazine() {
        System.out.println("We returned the magazine in UniLibrary.");
        System.out.println("--------------------------------");
    }

    public void addBook(String person_name, Book book) {
        System.out.println("We adding the book in UniLibrary.");
        System.out.println("--------------------------------");
    }

    public void addMagazine() {
        System.out.println("We adding the magazine in UniLibrary.");
        System.out.println("--------------------------------");
    }
}
