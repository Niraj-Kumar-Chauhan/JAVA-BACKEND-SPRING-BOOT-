package in.nirajarmy.AOPDemo_day16.controller;


import in.nirajarmy.AOPDemo_day16.dto.Student;
import in.nirajarmy.AOPDemo_day16.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent (@RequestBody Student student) {

        Student studentRes = studentService.createStudent(student);

        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod () {
        String s = "niraj";

        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
