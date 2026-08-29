package in.nirajarmy.spring_security_day_29.service;

import in.nirajarmy.spring_security_day_29.entity.CustomUserDetails;
import in.nirajarmy.spring_security_day_29.entity.User;
import in.nirajarmy.spring_security_day_29.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow
                        (
                                () -> new UsernameNotFoundException("user not fount")
                        );
        return new CustomUserDetails(user);
    }
}
