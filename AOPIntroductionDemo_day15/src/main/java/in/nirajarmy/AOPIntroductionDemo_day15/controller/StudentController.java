package in.nirajarmy.AOPIntroductionDemo_day15.controller;

import in.nirajarmy.AOPIntroductionDemo_day15.dto.Student;
import in.nirajarmy.AOPIntroductionDemo_day15.service.StudentService;
import in.nirajarmy.AOPIntroductionDemo_day15.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<String> createStudent (Student student) {
        studentService.createStudent(student);

        return ResponseEntity.ok("DONE");
    }
}
