package in.nirajarmy.spring_security_day_28.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    @GetMapping
    public ResponseEntity<String> getStudent () {

        return ResponseEntity.ok("student retrieved successfully");

    }

    @PostMapping
    public ResponseEntity<String> createStudent () {

        return ResponseEntity.ok("student created successfully");

    }

    @PutMapping
    public ResponseEntity<String> updateStudent () {

        return ResponseEntity.ok("student updated successfully");

    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent () {

        return ResponseEntity.ok("student deleted successfully");

    }

    @GetMapping("/getCsrfToken")
    public CsrfToken getToken (CsrfToken csrfToken) {
        return csrfToken;
    }
}
