package in.nirajarmy.pointcuts_day17.service;

import in.nirajarmy.pointcuts_day17.dto.Student;

import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    public Student createStudent (Student student) {
        System.out.println("student saved");

//        throw  new RuntimeException("some error happened");
        return student;
    }

    @Override
    public String getStudent (String s) {
        System.out.println(s);
        return s;
    }
}
