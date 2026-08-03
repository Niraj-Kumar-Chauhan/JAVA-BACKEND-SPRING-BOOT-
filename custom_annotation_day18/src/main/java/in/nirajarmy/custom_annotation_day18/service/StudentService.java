package in.nirajarmy.custom_annotation_day18.service;

import in.nirajarmy.custom_annotation_day18.annotation.TrackExecutionTime;
import in.nirajarmy.custom_annotation_day18.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "creating new student"
    )
    public Student createStudent (Student student) {
        System.out.println("student saved");

        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "get student data"
    )
    public String getStudent (String message) {
        try {
            Thread.sleep(2000);
        }catch (Exception e) {};

        System.out.println(message);
        return message;
    }
}
