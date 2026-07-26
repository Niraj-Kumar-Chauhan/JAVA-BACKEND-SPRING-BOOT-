package in.nirajarmy.AOPDemo_day16.service;


import in.nirajarmy.AOPDemo_day16.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent (Student student) {
        System.out.println("student saved");

//        throw  new RuntimeException("some error happened");
        return student;
    }

    public String dummyMethod (String s) {
        System.out.println("dummy method called");
        return s;
    }
}
