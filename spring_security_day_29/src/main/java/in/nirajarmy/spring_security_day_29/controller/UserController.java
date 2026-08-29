package in.nirajarmy.spring_security_day_29.controller;


import in.nirajarmy.spring_security_day_29.dto.UserRegisterRequestDto;
import in.nirajarmy.spring_security_day_29.dto.UserRegisterResponseDto;
import in.nirajarmy.spring_security_day_29.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController (AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public  String sayHello () {

        return "Hello";
    }


    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register
            (
                    @RequestBody UserRegisterRequestDto registerRequestDto
            ){
        UserRegisterResponseDto registerResponseDto
                = authService.register(registerRequestDto);

        return ResponseEntity.ok(registerResponseDto);
    }

    @GetMapping("/get-token")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
