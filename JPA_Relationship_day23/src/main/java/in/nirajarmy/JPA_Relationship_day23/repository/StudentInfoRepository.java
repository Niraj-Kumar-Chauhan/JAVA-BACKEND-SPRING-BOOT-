package in.nirajarmy.JPA_Relationship_day23.repository;


import in.nirajarmy.JPA_Relationship_day23.model.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(StudentInfo studentInfo) {
        entityManager.persist(studentInfo);
    }

    public StudentInfo getStudent(Long id) {
        return entityManager.find(StudentInfo.class, id);
    }

    public void deleteStudent(StudentInfo studentInfo) {
        entityManager.remove(studentInfo);
    }

    public List<StudentInfo> getAllStudentByDeptId (Long deptId) {
        return entityManager
                .createQuery(
                        "SELECT student FROM StudentInfo student WHERE student.department.id = :deptId",
                        StudentInfo.class
                )
                .setParameter("deptId", deptId)
                .getResultList();
    }
}
