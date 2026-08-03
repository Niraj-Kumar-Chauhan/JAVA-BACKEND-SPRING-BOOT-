package in.nirajarmy.custom_annotation_day18.aspect;

import in.nirajarmy.custom_annotation_day18.annotation.TrackExecutionTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforeMethod () {
//        System.out.println("Method Intercepted");
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime (
            ProceedingJoinPoint joinPoint,
            TrackExecutionTime trackExecutionTime
    ) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            String methodName = joinPoint.getSignature().getName();

            long endTime = System.currentTimeMillis();

            long duration = endTime - startTime;

            String operation = trackExecutionTime.operation();

            if (operation.isBlank()) {
                operation = joinPoint.getSignature().getName();
            }

            long warningTheshold = trackExecutionTime.warnAfter();

            if (duration >= warningTheshold) {
                System.out.println("SLOW OPERATION ALERT : " +
                                "Time taken by " +
                                operation + " : " + duration
                        );
            }else {
                System.out.println("Time taken by " + methodName + " : " + duration);
            }

        }
    }
}
