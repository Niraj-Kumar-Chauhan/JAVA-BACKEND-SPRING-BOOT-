package in.nirajarmy.spring_data_JPA_day_25.controller;


import in.nirajarmy.spring_data_JPA_day_25.model.Student;
import in.nirajarmy.spring_data_JPA_day_25.service.StudentService;
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
    public ResponseEntity<String> createStudent
            (
                    @RequestBody Student student
            ) {
        studentService.createStudent(student);

        return ResponseEntity.ok("student created successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent
            (
                    @PathVariable Long id
            ) {

        Student student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getAll (@PathVariable String name) {

        List<Student> studentList = studentService.getAll(name);

        return ResponseEntity.ok(studentList);
    }
 }
