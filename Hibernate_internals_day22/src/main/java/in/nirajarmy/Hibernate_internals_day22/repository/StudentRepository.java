package in.nirajarmy.Hibernate_internals_day22.repository;


import in.nirajarmy.Hibernate_internals_day22.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    // create
    public void save (Student student) {
        entityManager.persist(student);
    }

    public Student findById (Long id) {

        Student s1 = entityManager.find(Student.class, id);

        return  s1;
    }

    // remove
    public void remove (Student student) {
        entityManager.remove(student);
    }

    public Student attachAgain (Student student) {
        return entityManager.merge(student);
    }

    public void detach (Student student) {
        entityManager.detach(student);
    }

    public void flush () {
        entityManager.flush();
    }
}
