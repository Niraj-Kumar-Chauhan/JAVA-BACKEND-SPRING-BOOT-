package in.nirajarmy.spring_security_day_29.service;


import in.nirajarmy.spring_security_day_29.dto.UserRegisterRequestDto;
import in.nirajarmy.spring_security_day_29.dto.UserRegisterResponseDto;
import in.nirajarmy.spring_security_day_29.entity.Role;
import in.nirajarmy.spring_security_day_29.entity.User;
import in.nirajarmy.spring_security_day_29.repository.RoleRepository;
import in.nirajarmy.spring_security_day_29.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public AuthService
            (
                    UserRepository userRepository,
                    RoleRepository roleRepository,
                    PasswordEncoder passwordEncoder
            ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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

        Role role = roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto registerResponseDto = new UserRegisterResponseDto();

        registerResponseDto.setUsername(registerRequestDto.getUsername());

        registerResponseDto.setMessage("user registered successfully");

        return registerResponseDto;
    }
}
