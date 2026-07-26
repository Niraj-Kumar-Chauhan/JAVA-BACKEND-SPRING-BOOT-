package in.nirajarmy.exception_handling_day10.repository;

import in.nirajarmy.exception_handling_day10.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();

    List<Student> findByDeletedIsTrue();

    boolean existsByEmail(String emailId);

}