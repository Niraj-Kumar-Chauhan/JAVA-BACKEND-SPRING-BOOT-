package in.nirajarmy.interceptors_day14.controller;

import in.nirajarmy.interceptors_day14.entity.Student;
import in.nirajarmy.interceptors_day14.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent (Student student) {
        boolean createdStudent = studentService.createStudent(student);

        if (!createdStudent){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("student not found");
        }
        System.out.println("student controller called...");

        return ResponseEntity.ok("student created");
    }
}
