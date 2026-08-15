package in.nirajarmy.JPA_Relationship_day23.repository;


import in.nirajarmy.JPA_Relationship_day23.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save (Department department) {
        entityManager.persist(department);
    }

    public Department getDepartmentById(Long id) {
        return entityManager.find(Department.class, id);
    }

    public void deleteDepartment (Department department) {
        entityManager.remove(department);
    }
}
