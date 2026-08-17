package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.service;


import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Department;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Profile;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Student;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository.DepartmentRepository;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository.ProfileRepository;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private DepartmentRepository departmentRepository;

    private ProfileRepository profileRepository;

    public StudentService
            (
                    StudentRepository studentRepository,
                    DepartmentRepository departmentRepository,
                    ProfileRepository profileRepository
            ) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent (Student student) {

        Department department = new Department();

        department.setName("CSE");

        Profile profile = new Profile();

        profile.setName("see bio");

        student.setDepartment(department);
        student.setProfile(profile);

        studentRepository.save(student);
        departmentRepository.save(department);
        profileRepository.save(profile);
    }


    @Transactional
    public Student getStudent (Long id) {
        Student student = studentRepository.getStudent(id);

        System.out.println("Lazily fetched student: ");

        Department d1 = student.getDepartment();
        System.out.println("Lazily fetched department: ");

        Profile p1 = student.getProfile();
        System.out.println("Lazily fetched profile: ");

        return student;
    }
}
