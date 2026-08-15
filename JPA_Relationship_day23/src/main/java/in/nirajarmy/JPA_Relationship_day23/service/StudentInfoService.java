package in.nirajarmy.JPA_Relationship_day23.service;


import in.nirajarmy.JPA_Relationship_day23.model.Department;
import in.nirajarmy.JPA_Relationship_day23.model.StudentInfo;
import in.nirajarmy.JPA_Relationship_day23.repository.DepartmentRepository;
import in.nirajarmy.JPA_Relationship_day23.repository.StudentInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    private StudentInfoRepository studentInfoRepository;
    private  DepartmentRepository departmentRepository;

    public StudentInfoService(
            StudentInfoRepository studentInfoRepository,
            DepartmentRepository departmentRepository
    ) {
        this.studentInfoRepository = studentInfoRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public String createStudent(StudentInfo studentInfo, Long deptId) {

        Department department
                = departmentRepository.getDepartmentById(deptId);

        if (department == null) {
            return "student not created because department: " + null;
        }

        studentInfo.setDepartment(department);

        department.getStudentInfoList().add(studentInfo);

        studentInfoRepository.save(studentInfo);

        return "student created successfully";
    }


    @Transactional
    public void createStudent(StudentInfo studentInfo, String deptName) {
        Department department = new Department();

        department.setName(deptName);

        studentInfo.setDepartment(department);

        department.getStudentInfoList().add(studentInfo);

        departmentRepository.save(department);

        studentInfoRepository.save(studentInfo);
    }

    @Transactional
    public String updateStudent (
            StudentInfo studentReq,
            Long student_id,
            Long deptId
    ) {

        StudentInfo studentInfo
                = studentInfoRepository.getStudent(student_id);

        if (studentInfo == null) {
            return "student not found";
        }

        if (studentReq.getName().trim().isEmpty()) {
            return "student not updated because student_name is empty";
        }

        Department department
                = departmentRepository.getDepartmentById(deptId);

        if (department == null) {
            return "student not updated because department: " + null;
        }

        studentInfo.setName(studentReq.getName());
        studentInfo.setDepartment(department);

        studentInfoRepository.save(studentInfo);

        return "student updated successfully";
    }

    @Transactional
    public String deleteStudent(Long id) {
        StudentInfo studentInfo = studentInfoRepository.getStudent(id);

        if (studentInfo == null) {
            return "student not found";
        }

        studentInfoRepository.deleteStudent(studentInfo);

        return "student deleted successfully";
    }

    @Transactional
    public List<StudentInfo> getAllStudentByDeptId (Long deptId) {

        List<StudentInfo> studentsList =
                studentInfoRepository.getAllStudentByDeptId(deptId);

        return studentsList;
    }
}
