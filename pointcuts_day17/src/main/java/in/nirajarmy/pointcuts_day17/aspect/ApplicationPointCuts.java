package in.nirajarmy.pointcuts_day17.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointCuts {

    @Pointcut("within(in.nirajarmy.pointcuts_day17.controller..*)")
    public void controllerLayer () {
        // empty body
    }

    @Pointcut("within(in.nirajarmy.pointcuts_day17.service..*)")
    public void serviceLayer () {
        // empty body
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod () {
        // empty body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod () {
        // empty body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethod () {
        // empty body
    }

}
