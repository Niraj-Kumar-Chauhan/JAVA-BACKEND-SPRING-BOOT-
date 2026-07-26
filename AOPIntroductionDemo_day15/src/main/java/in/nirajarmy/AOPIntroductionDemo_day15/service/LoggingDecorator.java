package in.nirajarmy.AOPIntroductionDemo_day15.service;

import in.nirajarmy.AOPIntroductionDemo_day15.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {
    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator (StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        LoggingServiceUtil.start(
                "StudentServiceImpl", "createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.end(
                "StudentServiceImpl", "createStudent");
    }
}
