package in.nirajarmy.dtoDemo_day9.controller;

import in.nirajarmy.dtoDemo_day9.dto.CreateStudentRequestDto;
import in.nirajarmy.dtoDemo_day9.dto.CreateStudentResponseDto;
import in.nirajarmy.dtoDemo_day9.dto.UpdateStudentRequestDto;
import in.nirajarmy.dtoDemo_day9.dto.UpdateStudentResponseDto;
import in.nirajarmy.dtoDemo_day9.entity.Student;
import in.nirajarmy.dtoDemo_day9.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // create student
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto createStudentRequestDto
    ) {
        CreateStudentResponseDto createdStudent =
                studentService.createStudent(createStudentRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //get student
    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getOneStudent(
            @RequestParam Long id
    ) {
        CreateStudentResponseDto sutdentRes =
                studentService.getOneStudent(id);

        if (sutdentRes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sutdentRes);
    }

    //get all student
    @GetMapping("/get-all")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList =
                studentService.getAllStudent();

        if (studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    // update student info
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent (
            @RequestParam Long id,
            @RequestBody UpdateStudentRequestDto student
    ) {
        UpdateStudentResponseDto updatedStudent =
                studentService.updateStudent(id, student);

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
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("student not found for delete");
        }

        return ResponseEntity
                    .ok("student delete successfully which has soft-deleted is true");
    }
}
