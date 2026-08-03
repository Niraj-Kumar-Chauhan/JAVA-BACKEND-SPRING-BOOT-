package in.nirajarmy.pointcuts_day17.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Pointcut("within(in.nirajarmy.pointcuts_day17.service..*) " +
//            "&& " +
//            "execution(public * * (..))")
//    public void logPublicServiceMethod() {
//        //empty body
//    }

//    @Before("in.nirajarmy.pointcuts_day17.aspect.ApplicationPointCuts.publicServiceMethod()")
//    public void logBeforeMethod () {
//        System.out.println("Method Intercepted");
//    }

//      @Before("@within(org.springframework.stereotype.Service)")
//      public void logBeforeMethod2() {
//          System.out.println("Method Intercepted");
//      }

//    @Before("args(in.nirajarmy.pointcuts_day17.dto.Student) " +
//            "&& " +
//            "within(in.nirajarmy.pointcuts_day17.service..*)")
//    public void logBeforeMethod3() {
//        System.out.println("Method Intercepted");
//    }

//    @Before("@args(jdk.jfr.Timestamp) " +
//            "&& " +
//            "within(in.nirajarmy.pointcuts_day17.service..*)")
//    public void logBeforeMethod3() {
//        System.out.println("Method Intercepted");
//    }

//    @Before("target(in.nirajarmy.pointcuts_day17.service.StudentService)")
//    public void logBeforeMethod4() {
//        System.out.println("Method Intercepted");
//    }

    @Before("this(in.nirajarmy.pointcuts_day17.service.StudentService)")
    public void logBeforeMethod4() {
        System.out.println("Method Intercepted");
    }

//    @Before("execution(in.nirajarmy.pointcuts_day17.dto.Student " +
//            "in.nirajarmy.pointcuts_day17.service.StudentService.createStudent(" +
//            "in.nirajarmy.pointcuts_day17.dto.Student))")
//    public void logBeforeMethod2 () {
//        System.out.println("Method Intercepted");
//    }
}
