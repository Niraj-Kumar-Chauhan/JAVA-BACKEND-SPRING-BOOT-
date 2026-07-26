package in.nirajarmy.AOPIntroductionDemo_day15.service;

import in.nirajarmy.AOPIntroductionDemo_day15.dto.Student;
import in.nirajarmy.AOPIntroductionDemo_day15.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent (Student student) {

        studentRepository.save();

    }
}
