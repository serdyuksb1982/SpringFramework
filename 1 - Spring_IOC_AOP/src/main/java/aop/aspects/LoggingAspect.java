package aop.aspects;


import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

   /* @Pointcut("execution(* aop.UniLibrary.*(..))")

    private void allMethodsFromUniLibrary() {
    }

    @Pointcut("execution( * aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {
    }

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void  allMethodExceptReturnMagazineFromUniLibrary() {
    }

    @Before("allMethodExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazine() {
        System.out.println("   beforeAllMethodsExceptReturnMagazine: writing Log #4");
    }*/

    /*@Pointcut("execution(* aop.UniLibrary.get*())")
      private void allGetMethodsFromUniLibrary() {
    }

    @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allReturnMethodsFromUniLibrary() {
    }

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    public void allGetAndReturnMethodsFromUniLibrary() {

    }

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: writing Log #1 ");
    }



    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice() {
        System.out.println("beforeReturnLoggingAdvice: writing Log #2 ");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice() {
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3 ");
    }*/


    /*@Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): "
                + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): "
                + methodSignature.getReturnType());
        System.out.println("methodSignature.getReturnType(): "
                + methodSignature.getName());
        if(methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if(obj instanceof Book) {
                    Book myBook = (Book)  obj;
                    System.out.println("Информация о книге: название - " +
                            myBook.getName() + ", автор - " + myBook.getAuthor() + ", год издания: " + myBook.getYersOfPublication());
                }
                else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetLoggingAdvice: attempt logging to get a book/magazine.");
        System.out.println("--------------------------------");
    }*/



}
