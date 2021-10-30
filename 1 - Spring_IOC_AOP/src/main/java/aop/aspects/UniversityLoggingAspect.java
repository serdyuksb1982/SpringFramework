package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    /*@Before("execution(* getStudents())")
    public void beforeGetStudentLoggingAdvice() {
        System.out.println("beforeGetStudentLoggingAdvice: " +
                "логгируем получение списка студентов перед методом getStudents()." );
    }*/

    /*@AfterReturning(pointcut = "execution(* getStudents())"
    , returning = "students")
    public void afterReturningGetStudentLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr. ".concat(nameSurname);
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firstStudent.setAvgGrade(avgGrade);
        System.out.println("afterReturningGetStudentLoggingAdvice: " +
                "логгируем получение списка студентов после метода getStudents()." );
    }*/

   /* @AfterThrowing(pointcut = "execution(* getStudents())"
    , throwing = "exception")
    public void afterThrowingGetStudentLoggingAdvice(Throwable exception) {
        System.out.println("afterThrowingGetStudentLoggingAdvice логгируем выброс " +
                "исключения " + exception);
    }*/

    @After(("execution(* getStudents())"))
    public void afterGetStudentLoggingAdvice() {
        System.out.println("afterGetStudentLoggingAdvice: " +
                "логгируем нормальное окончание работы или выброс исключения." );
    }
}
