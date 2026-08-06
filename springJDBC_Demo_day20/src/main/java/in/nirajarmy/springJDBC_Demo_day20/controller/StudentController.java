package in.nirajarmy.springJDBC_Demo_day20.controller;

import in.nirajarmy.springJDBC_Demo_day20.model.Student;
import in.nirajarmy.springJDBC_Demo_day20.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);

        return ResponseEntity.ok("STUDENT CREATED");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent () {
        List<Student> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable Long id) {
        Student studentRes = studentService.getStudentById(id);

        return ResponseEntity.ok(studentRes);
    }

    @PutMapping
    public ResponseEntity<String> updateStudent (@RequestBody Student student) {
        studentService.updateStudent(student);

        return ResponseEntity.ok("STUDENT UPDATED");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.ok("STUDENT DELETED");
    }
}
