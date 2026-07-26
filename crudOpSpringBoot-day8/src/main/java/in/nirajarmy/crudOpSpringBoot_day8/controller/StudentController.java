package in.nirajarmy.crudOpSpringBoot_day8.controller;

import in.nirajarmy.crudOpSpringBoot_day8.entity.Student;
import in.nirajarmy.crudOpSpringBoot_day8.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //get student
    @GetMapping("/get")
    public ResponseEntity<Student> getOneStudent(@RequestParam Long id) {
        Student sutdentRes = studentService.getOneStudent(id);
        if (sutdentRes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sutdentRes);
    }

    //get all student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();

        if (studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    // update student info
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent (
            @RequestParam Long id,
            @RequestBody Student student
    ) {
        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    // delete student
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Boolean isStudent = studentService.deleteStudent(id);

        if (!isStudent) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Record not found");
        }

        return ResponseEntity.ok("Record Deleted");
    }

    // delete All Student
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStudent (){
        Boolean deletedAllStudent = studentService.deleteAllStudent();

        if (deletedAllStudent == false){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("students not found");
        }
        return ResponseEntity.ok("All Student deleted");
    }

    // delet student softly
    @PatchMapping("/delete-softly")
    public ResponseEntity<String> deleteStudentSoftly (@RequestParam Long id) {
        boolean isStudent =
                studentService.deleteStudentSoftly (id);
        if (!isStudent){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("student not found");
        }

        return ResponseEntity.ok("Student softly deleted successfully");
    }

    //get all student which is soft-deleted true
    @GetMapping("/getAll-soft-deleted-true")
    public ResponseEntity<List<Student>> getAllSoftDeletedStudent () {
        List<Student> getSoftyDeletedStudentList =
                studentService.getAllSoftlyDeletedStudent();

        if (getSoftyDeletedStudentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getSoftyDeletedStudentList);
    }

    // delete all student softly
    @PatchMapping("/delete-all-softly")
    public ResponseEntity<String> deleteSoftlyAllStudent () {
        Boolean isDeleteAllStudentSoftly =
                studentService.deleteSoftlyAllStudent();

        if (isDeleteAllStudentSoftly == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("student not found");
        }

        return ResponseEntity.ok("All student deleted softly");
    }

    @DeleteMapping("/delete-all-soft-deleted-true")
    public ResponseEntity<String> deleteAllSoftDeletedStudent () {
        Boolean isStudentExist = studentService.deleteAllSoftlyDeletedStudent();

        if (isStudentExist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found for delete");
        }

        return ResponseEntity.ok("student delete successfully which has soft-deleted is true");
    }
}

