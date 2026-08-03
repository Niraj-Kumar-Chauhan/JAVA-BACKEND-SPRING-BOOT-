package in.nirajarmy.pointcuts_day17.controller;

import in.nirajarmy.pointcuts_day17.dto.Student;
import in.nirajarmy.pointcuts_day17.service.StudentService;
import in.nirajarmy.pointcuts_day17.service.StudentServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentServiceInterface studentService;

    public StudentController (StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent (@RequestBody Student student) {

        Student studentRes = studentService.createStudent(student);

        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<String> getStudent () {
        String s = "All student data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}