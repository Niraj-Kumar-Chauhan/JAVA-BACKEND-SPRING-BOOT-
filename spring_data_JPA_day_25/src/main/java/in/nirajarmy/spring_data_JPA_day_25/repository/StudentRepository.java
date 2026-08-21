package in.nirajarmy.spring_data_JPA_day_25.repository;


import in.nirajarmy.spring_data_JPA_day_25.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface StudentRepository  extends JpaRepository<Student, Long> {

//     void save(Student student);
//
     Optional<Student> findById(Long id);

     @Query(value = """
      select * from student 
      where email = :email""", nativeQuery = true)
     Optional<Student> findByEmail(@Param("email") String email);
}
