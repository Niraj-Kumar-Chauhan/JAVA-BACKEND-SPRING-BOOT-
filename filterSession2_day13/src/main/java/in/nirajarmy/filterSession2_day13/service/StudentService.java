package in.nirajarmy.filterSession2_day13.service;

import in.nirajarmy.filterSession2_day13.dto.Student;
import in.nirajarmy.filterSession2_day13.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDto createStudent (Student student) {

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setMessage(
                "student is saved successfully"
        );

        return studentResponseDto;
    }
}
