package in.nirajarmy.OauthDemo_day_30.service;


import in.nirajarmy.OauthDemo_day_30.entity.User;
import in.nirajarmy.OauthDemo_day_30.repository.UserRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerOrUpdate(String provider, OidcUser oidcUser) {

        String providerSubject = oidcUser.getSubject();

        String name = oidcUser.getName();

        String email = oidcUser.getEmail();

        Optional<User> existingUser
                = userRepository.findByProviderAndProviderSubject(provider, providerSubject);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            user.setName(name);

            user.setEmail(email);

            return user;
        }

        User newUser = new User(name, email, provider, providerSubject);

        return userRepository.save(newUser);
    }

    public Optional<User> findByProviderAndSubject
            (
                    String provider, String subject
            ) {

        return userRepository.findByProviderAndProviderSubject
                (
                        provider, subject
                );
    }
}
