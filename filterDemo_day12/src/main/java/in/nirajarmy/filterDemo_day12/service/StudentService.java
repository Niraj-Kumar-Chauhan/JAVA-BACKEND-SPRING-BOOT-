package in.nirajarmy.filterDemo_day12.service;

import in.nirajarmy.filterDemo_day12.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent (Student student) {
        System.out.println("student created successfully");

        System.out.println(student.getName());
        System.out.println(student.getEmail());

//        try {
//            Thread.sleep(2000);
//        }catch (Exception e) {}
    }
}
