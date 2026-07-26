package in.nirajarmy.exception_handling_day10.controller;

import in.nirajarmy.exception_handling_day10.dto.CreateStudentRequestDto;
import in.nirajarmy.exception_handling_day10.dto.CreateStudentResponseDto;
import in.nirajarmy.exception_handling_day10.dto.UpdateStudentRequestDto;
import in.nirajarmy.exception_handling_day10.dto.UpdateStudentResponseDto;
import in.nirajarmy.exception_handling_day10.entity.Student;
import in.nirajarmy.exception_handling_day10.exception.DuplicateResourceException;
import in.nirajarmy.exception_handling_day10.service.StudentService;
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
    @PostMapping
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
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getOneStudent(
            @PathVariable Long id
    ) {
        CreateStudentResponseDto sutdentRes =
                studentService.getOneStudent(id);

        return ResponseEntity.ok(sutdentRes);
    }

    //get all student
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList =
                studentService.getAllStudent();

        return ResponseEntity.ok(studentList);
    }

    // update student info
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent (
            @RequestParam Long id,
            @RequestBody UpdateStudentRequestDto student
    ) {
        UpdateStudentResponseDto updatedStudent =
                studentService.updateStudent(id, student);


        return ResponseEntity.ok(updatedStudent);
    }

    // delete student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    // delete All Student
//    @DeleteMapping("/deleteAll")
//    public ResponseEntity<String> deleteAllStudent (){
//        Boolean deletedAllStudent = studentService.deleteAllStudent();
//
//        if (deletedAllStudent == false){
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("students not found");
//        }
//        return ResponseEntity.ok("All Student deleted");
//    }

    // delet student softly
    @PatchMapping("/delete-softly")
    public ResponseEntity<String> deleteStudentSoftly (@RequestParam Long id) {
        studentService.deleteStudentSoftly (id);

        return ResponseEntity.noContent().build();
    }

    //get all student which is soft-deleted true
//    @GetMapping("/getAll-soft-deleted-true")
//    public ResponseEntity<List<Student>> getAllSoftDeletedStudent () {
//        List<Student> getSoftyDeletedStudentList =
//                studentService.getAllSoftlyDeletedStudent();
//
//        if (getSoftyDeletedStudentList.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(getSoftyDeletedStudentList);
//    }
//
//    // delete all student softly
//    @PatchMapping("/delete-all-softly")
//    public ResponseEntity<String> deleteSoftlyAllStudent () {
//        Boolean isDeleteAllStudentSoftly =
//                studentService.deleteSoftlyAllStudent();
//
//        if (isDeleteAllStudentSoftly == null){
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("student not found");
//        }
//
//        return ResponseEntity.ok("All student deleted softly");
//    }
//
//    @DeleteMapping("/delete-all-soft-deleted-true")
//    public ResponseEntity<String> deleteAllSoftDeletedStudent () {
//        Boolean isStudentExist = studentService.deleteAllSoftlyDeletedStudent();
//
//        if (isStudentExist == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("student not found for delete");
//        }
//
//        return ResponseEntity
//                .ok("student delete successfully which has soft-deleted is true");
//    }
}