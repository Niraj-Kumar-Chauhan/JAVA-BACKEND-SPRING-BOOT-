package in.nirajarmy.filterSession2_day13.controller;

import in.nirajarmy.filterSession2_day13.dto.Student;
import in.nirajarmy.filterSession2_day13.dto.StudentResponseDto;
import in.nirajarmy.filterSession2_day13.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent
            (@RequestBody Student student) {
        StudentResponseDto studentResponseDto = studentService.createStudent(student);

        return ResponseEntity.ok(studentResponseDto);
    }

}
