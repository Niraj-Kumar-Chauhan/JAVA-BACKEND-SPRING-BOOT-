package in.nirajarmy.AOPIntroductionDemo_day15.service;

public class LoggingServiceUtil {

    public static void start (String className, String methodName) {
        System.out.println("Executing -> " + className + " : " + methodName);
    }

    public static void end (String className, String methodName) {
        System.out.println("Finishing -> " + className + " : " + methodName);
    }
}
