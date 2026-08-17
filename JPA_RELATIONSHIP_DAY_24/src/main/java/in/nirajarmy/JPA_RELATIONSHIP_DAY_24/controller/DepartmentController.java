package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.controller;


import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Department;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


//    @PostMapping
//    public ResponseEntity<String> createDepartment
//            (
//                    @RequestBody Department department
//            ) {
//        departmentService.createDepartment(department);
//
//        return ResponseEntity.ok("department created successfully");
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment (@PathVariable Long id) {
        departmentService.deleteDepartment(id);

        return ResponseEntity.ok("department deleted successfully");
    }
}
