package in.nirajarmy.JPA_Relationship_day23.service;


import in.nirajarmy.JPA_Relationship_day23.model.Department;
import in.nirajarmy.JPA_Relationship_day23.model.StudentInfo;
import in.nirajarmy.JPA_Relationship_day23.repository.DepartmentRepository;
import in.nirajarmy.JPA_Relationship_day23.repository.StudentInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentInfoRepository studentInfoRepository;

    public DepartmentService (
            DepartmentRepository departmentRepository,
            StudentInfoRepository studentInfoRepository
    ) {
        this.departmentRepository = departmentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }

    @Transactional
    public void createDepartment (Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment (
            Department department,
            String studentName
    ) {
        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setName(studentName);
        studentInfo.setDepartment(department);

        department.getStudentInfoList().add(studentInfo);

        studentInfoRepository.save(studentInfo);
        departmentRepository.save(department);
    }


    @Transactional
    public String deleteDepartment (Long id) {



        Department department  = departmentRepository.getDepartmentById(id);

        if (department == null) {
            return "department not found with id: " + id;
        }

        departmentRepository.deleteDepartment(department);

        return "department deleted successfully";
    }
}
