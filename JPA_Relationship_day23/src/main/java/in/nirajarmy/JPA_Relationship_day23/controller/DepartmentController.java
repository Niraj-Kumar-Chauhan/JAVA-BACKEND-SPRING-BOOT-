package in.nirajarmy.JPA_Relationship_day23.controller;


import in.nirajarmy.JPA_Relationship_day23.model.Department;
import in.nirajarmy.JPA_Relationship_day23.model.StudentInfo;
import in.nirajarmy.JPA_Relationship_day23.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment
            (@RequestBody Department department) {

        departmentService.createDepartment(department);

        return ResponseEntity.ok("department created successfully");
    }


    @PostMapping("/withStudent")
    public ResponseEntity<String> createDepartment
            (
                    @RequestBody Department department,
                    @RequestParam String studentName
            ) {

        departmentService.createDepartment(department, studentName);

        return ResponseEntity.ok("department created successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDepartment (@RequestParam Long id) {

        String deptRes = departmentService.deleteDepartment(id);

        return ResponseEntity.ok(deptRes);
    }
}
