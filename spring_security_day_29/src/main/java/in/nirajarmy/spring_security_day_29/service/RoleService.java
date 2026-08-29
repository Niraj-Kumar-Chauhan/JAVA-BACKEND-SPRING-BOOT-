package in.nirajarmy.spring_security_day_29.service;


import in.nirajarmy.spring_security_day_29.entity.Role;
import in.nirajarmy.spring_security_day_29.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole (Role role) {
        roleRepository.save(role);
    }
}
