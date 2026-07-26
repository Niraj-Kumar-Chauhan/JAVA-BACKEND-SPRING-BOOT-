package in.nirajarmy.AOPDemo_day16.aspect;


import in.nirajarmy.AOPDemo_day16.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String in.nirajarmy.AOPDemo_day16.service.StudentService.createStudent())")
//    public void loggingBeforeMethod (JoinPoint joinPoint) {
//
//        Object[] arr = joinPoint.getArgs();
//
//        System.out.println("loggingBeforeMethod called");
//

    /// /        boolean allowed = false;
    /// /
    /// /        if (!allowed) {
    /// /            throw new RuntimeException("Method Execution not allowed");
    /// /        }
//    }


//    @AfterReturning(
//            value = "execution(* in.nirajarmy.AOPDemo_day16.service" +
//                    ".StudentService" +
//                    ".createStudent(..))",
//            returning = "result"
//    )
//    public void logAfterReturningMethod (Student result) {
//
//        result.setName("Rohit");
//        result.setAge(25);
//
//        System.out.println("Intercepted createStudent()");
//    }


//    @AfterThrowing(
//            value = "execution(* in.nirajarmy.AOPDemo_day16.service" +
//                    ".StudentService" +
//                    ".createStudent(..))",
//            throwing = "exception"
//
//    )
//    public void logAfterThrowingMethod (RuntimeException exception) {
//
//        System.out.println("Exception Type: " + exception.getClass().getName());
//        System.out.println("Exception Message: " + exception.getMessage());
//    }


//    @After(
//            value = "execution(* in.nirajarmy.AOPDemo_day16.service" +
//                    ".StudentService" +
//                    ".createStudent(..))"
//
//    )
//    public void logAfterMethod () {
//        System.out.println("logAfterMethod executed");
//    }




//    @Around(
//            value = "execution(* in.nirajarmy.AOPDemo_day16.service" +
//                    ".StudentService" +
//                    ".createStudent(..))"
//
//    )
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("Starting: " + joinPoint.getSignature().getName());
//
//        try {
//            Object result = joinPoint.proceed();
//
//            System.out.println("Execution Successful");
//
//            return result;
//        }catch (Exception e) {
//            System.out.println("Execution Failed");
//            throw e;
//        }
//        finally {
//            System.out.println("Execution Completed");
//        }
//    }



    @Around(
            value = "execution(* in.nirajarmy.AOPDemo_day16.service" +
                    ".StudentService" +
                    ".dummyMethod(..))"

    )
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

//        System.out.println("Starting: " + joinPoint.getSignature().getName());
//
//        Object[] arr = joinPoint.getArgs();
//
//        String originalString = (String) arr[0];
//
//        String modifiedString = originalString.toUpperCase();
//
//        Object[] modifiedArr = { modifiedString };
//
//        String returnType = (String) joinPoint.proceed(modifiedArr);
//
//        returnType = returnType + " : string intercepted";
//
//        return returnType;

        Object return1 = joinPoint.proceed();

        System.out.println("Intercepted request calling again");

        Object return2 = joinPoint.proceed();

        return return2;
    }
}
