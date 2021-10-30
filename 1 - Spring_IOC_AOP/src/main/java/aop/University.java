package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Sergey Serdyuk",
                4, 8);
        Student st2 = new Student("Ksenia Kiseleva",
                1, 7.9);
        Student st3 = new Student("Aleksey Kiselev",
                5, 9.9);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы метода getStudents");
        //System.out.println(students.get(students.size() + 1));
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }
}
