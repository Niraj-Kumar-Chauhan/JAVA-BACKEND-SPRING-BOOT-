package in.nirajarmy.spring_security_day_29.repository;

import in.nirajarmy.spring_security_day_29.entity.Role;
import in.nirajarmy.spring_security_day_29.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
