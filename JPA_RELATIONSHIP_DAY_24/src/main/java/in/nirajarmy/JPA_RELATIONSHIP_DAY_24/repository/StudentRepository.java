package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository;


import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save (Student student) {
        entityManager.persist(student);
    }

    public Student getStudent (Long id) {
        return entityManager.find(Student.class, id);
    }

//    @EntityGraph(attributePaths = {"department", "profile"})
//    public List<Student> findAll () {
//        // let me here something logic
//    }
}
