package in.nirajarmy.custom_annotation_day18.controller;

import in.nirajarmy.custom_annotation_day18.dto.Student;
import in.nirajarmy.custom_annotation_day18.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent (@RequestBody Student student) {
        Student studentRes = studentService.createStudent(student);

        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<String> getStudent () {
        String msg = "All student fetched";
        return ResponseEntity.ok(studentService.getStudent(msg));
    }
}
