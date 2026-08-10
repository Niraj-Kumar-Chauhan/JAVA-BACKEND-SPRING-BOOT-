package in.nirajarmy.Hibernate_internals_day22.service;


import in.nirajarmy.Hibernate_internals_day22.model.Student;
import in.nirajarmy.Hibernate_internals_day22.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent (Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudent (Long id) {

        Student studentRes = studentRepository.findById(id);
        if (studentRes == null) {
            throw new RuntimeException("student not found");
        }
        return studentRes;
    }


    @Transactional
    public void updateStudent (Student studentReq, Long id) {
        Student studentRes = studentRepository.findById(id);

        if (studentRes == null) {
            throw new RuntimeException("student not found");
        }

//        studentRepository.detach(studentRes);
//        studentRes = studentRepository.attachAgain(studentRes);

        studentRes.setName(studentReq.getName());
        studentRepository.flush();

        studentRes.setEmail(studentReq.getEmail());
//        studentRepository.flush();

        studentRes.setAge(studentReq.getAge());
//        studentRepository.flush();
    }


    @Transactional
    public void deleteStudent (Long id) {

        Student studentRes = studentRepository.findById(id);

        if (studentRes == null) {
            throw new RuntimeException("student not found");
        }
        studentRepository.remove(studentRes);
    }
}
