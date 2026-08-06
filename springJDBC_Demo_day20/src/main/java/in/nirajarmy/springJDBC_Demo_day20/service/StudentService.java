package in.nirajarmy.springJDBC_Demo_day20.service;

import in.nirajarmy.springJDBC_Demo_day20.model.Student;
import in.nirajarmy.springJDBC_Demo_day20.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void createStudent (Student student) {
            studentRepository.createStudent(student);
    }

    public List<Student> getAllStudent () {
        return studentRepository.getStudents();
    }

    public Student getStudentById (Long id) {
        return studentRepository.getStudentById(id);
    }

    public void  updateStudent (Student student) {
        studentRepository.updateStudent(student, student.getId());
    }

    public void deleteStudent (Long id) {
        studentRepository.deleteStudent(id);
    }
}
