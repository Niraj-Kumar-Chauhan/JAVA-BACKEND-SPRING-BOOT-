package in.nirajarmy.HibernateDemo_day21.service;

import in.nirajarmy.HibernateDemo_day21.model.Student;
import in.nirajarmy.HibernateDemo_day21.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository =  studentRepository;
    }

    @Transactional
    public void createStudent (Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById (Long id) {
        return studentRepository.findById(id);
    }

//    public List<Student> getAllStudent () {
//        return null;
//    }

    @Transactional
    public void updateStudent (Student studentReq, Long id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new RuntimeException("student not found");
        }

        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());

    }

    @Transactional
    public void deleteStudent (Long id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new RuntimeException("student not found");
        }

        studentRepository.remove(student);
    }
}
