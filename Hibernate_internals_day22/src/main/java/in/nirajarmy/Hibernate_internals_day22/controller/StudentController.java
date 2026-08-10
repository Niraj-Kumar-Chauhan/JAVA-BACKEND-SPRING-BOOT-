package in.nirajarmy.Hibernate_internals_day22.controller;


import in.nirajarmy.Hibernate_internals_day22.model.Student;
import in.nirajarmy.Hibernate_internals_day22.service.StudentService;
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
    public ResponseEntity<String> createStudent (@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("student created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent (
            @RequestBody Student student,
            @PathVariable Long id
    ) {
        studentService.updateStudent(student, id);
        return ResponseEntity.ok("student updated successfully");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.ok("student deleted successfully");
    }
}
