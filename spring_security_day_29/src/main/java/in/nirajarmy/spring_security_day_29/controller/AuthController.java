package in.nirajarmy.spring_security_day_29.controller;


import in.nirajarmy.spring_security_day_29.dto.LoginRequestDto;
import in.nirajarmy.spring_security_day_29.dto.LoginResponseDto;
import in.nirajarmy.spring_security_day_29.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public LoginResponseDto login
            (
                    @RequestBody LoginRequestDto loginRequestDto
            ) {

        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated
                        (
                                loginRequestDto.getUsername(),
                                loginRequestDto.getPassword()
                        );

        Authentication authentication =
                authenticationManager.authenticate(authenticationRequest);


        String token = jwtService.generateToken(authentication);

        return new LoginResponseDto(token);
    }
}
