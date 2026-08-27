package in.nirajarmy.spring_security_day_29.repository;

import in.nirajarmy.spring_security_day_29.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
