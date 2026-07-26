package in.nirajarmy.interceptors_day14.service;

import in.nirajarmy.interceptors_day14.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public boolean createStudent(Student student) {

        if (student == null) {
            return false;
        }

        System.out.println("student name: " + student.getName());
        System.out.println("student email: " + student.getEmail());

        return true;
    }
}
