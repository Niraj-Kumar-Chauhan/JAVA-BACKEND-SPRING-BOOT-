package in.nirajarmy.HibernateDemo_day21.controller;


import in.nirajarmy.HibernateDemo_day21.model.Student;
import in.nirajarmy.HibernateDemo_day21.service.StudentService;
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
    public ResponseEntity<String> createStudent (@RequestBody Student student) {
        studentService.createStudent(student);
        return  ResponseEntity.ok("student created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable Long id) {
        Student student  = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudent () {
//        List<Student> students = studentService.getAllStudent();
//
//        return (ResponseEntity<List<Student>>) students;
//    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent (
            @RequestBody Student student,
            @PathVariable Long id
    ) {
        studentService.updateStudent(student, id);

        return  ResponseEntity.ok("student updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("student deleted");
    }
}
