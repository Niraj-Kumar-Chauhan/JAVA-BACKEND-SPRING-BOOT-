package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.service;


import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Department;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Student;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository.DepartmentRepository;
import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    //private StudentRepository studentRepository;

    public DepartmentService (
            DepartmentRepository departmentRepository,
            StudentRepository studentRepository
    ) {
        this.departmentRepository = departmentRepository;
        //this.studentRepository = studentRepository;
    }

//    @Transactional
//    public void createDepartment (Department department) {
//
//        Student s1 = new Student();
//        s1.setName("rohit");
//        s1.setDepartment(department);
//
//        Student s2 = new Student();
//        s2.setName("shivam");
//        s2.setDepartment(department);
//
//        Student s3 = new Student();
//        s3.setName("raju");
//        s3.setDepartment(department);
//
//        department.getStudents().addAll(List.of(s1, s2, s3));
//
//        departmentRepository.save(department);
//
////        studentRepository.save(s1);
////        studentRepository.save(s2);
////        studentRepository.save(s3);
//    }

    @Transactional
    public void deleteDepartment (Long id) {
        Department department = departmentRepository.find(id);

        departmentRepository.removeDepartment(department);
    }
}
