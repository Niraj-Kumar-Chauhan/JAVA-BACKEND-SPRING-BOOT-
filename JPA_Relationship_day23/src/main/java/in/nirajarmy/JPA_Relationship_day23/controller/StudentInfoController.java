package in.nirajarmy.JPA_Relationship_day23.controller;


import in.nirajarmy.JPA_Relationship_day23.model.StudentInfo;
import in.nirajarmy.JPA_Relationship_day23.service.StudentInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentInfoController {

    private StudentInfoService studentInfoService;

    public StudentInfoController(
            StudentInfoService studentInfoService
    ) {
        this.studentInfoService = studentInfoService;
    }


    @PostMapping
    public ResponseEntity<String> createStudent (
            @RequestBody StudentInfo studentInfo,
            @RequestParam Long deptId
    ) {
        String studentRes = studentInfoService.createStudent(studentInfo, deptId);

        return ResponseEntity.ok(studentRes);
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent (
            @RequestBody StudentInfo studentInfo,
            @RequestParam String deptName
    ) {

        studentInfoService.createStudent(studentInfo, deptName);

        return ResponseEntity.ok("student created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateStudent
            (
                    @RequestBody StudentInfo studentInfo,
                    @RequestParam Long student_id,
                    @RequestParam Long deptId
            ) {

        String studentRes = studentInfoService
                .updateStudent(studentInfo,student_id, deptId);

        return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent (@RequestParam Long id) {
        String studentRes = studentInfoService.deleteStudent(id);

        return ResponseEntity.ok(studentRes);
    }

    @GetMapping("/get-all-student-which-have-deptId")
    public ResponseEntity<List<StudentInfo>> getAllStudentByDeptId
            (
                    @RequestParam Long deptId
            ) {
        System.out.println("Hello, In getAllStudentByDeptId");
        List<StudentInfo> studentsList =
                studentInfoService.getAllStudentByDeptId(deptId);

        return ResponseEntity.ok(studentsList);
    }
}
