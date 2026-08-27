package in.nirajarmy.spring_security_day_29.service;


import in.nirajarmy.spring_security_day_29.dto.UserRegisterRequestDto;
import in.nirajarmy.spring_security_day_29.dto.UserRegisterResponseDto;
import in.nirajarmy.spring_security_day_29.entity.User;
import in.nirajarmy.spring_security_day_29.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService
            (
                    UserRepository userRepository
            ) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponseDto register
            (
                    UserRegisterRequestDto registerRequestDto
            ) {
        User user = new User();

        user.setUsername(registerRequestDto.getUsername());

        String encodedPassword =
                passwordEncoder.encode(registerRequestDto.getPassword());

        user.setEnabled(true);

        user.setPassword(encodedPassword);

        userRepository.save(user);

        UserRegisterResponseDto registerResponseDto = new UserRegisterResponseDto();

        registerResponseDto.setUsername(registerRequestDto.getUsername());

        registerResponseDto.setMessage("user registered successfully");

        return registerResponseDto;
    }

    public Boolean login (UserRegisterRequestDto registerRequestDto) {

        Optional<User> userOptional
                = userRepository.findByUsername(registerRequestDto.getUsername());

        User user = userOptional.get();

        String encodedPassword = user.getPassword();

        return passwordEncoder
                .matches
                        (
                                registerRequestDto.getPassword(),
                                encodedPassword
                        );
    }
}
