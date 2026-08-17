package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.controller;


import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Student;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.service.StudentService;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<String> createStudent
            (
                    @RequestBody Student student
            ) {

        studentService.createStudent(student);

        return ResponseEntity.ok("student created successfully");

    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent (@PathVariable Long id) {

        Student student = studentService.getStudent(id);

        return ResponseEntity.ok(student);
    }
}
