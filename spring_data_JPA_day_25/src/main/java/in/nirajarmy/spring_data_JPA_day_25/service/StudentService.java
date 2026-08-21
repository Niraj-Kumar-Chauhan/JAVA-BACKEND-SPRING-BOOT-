package in.nirajarmy.spring_data_JPA_day_25.service;


import in.nirajarmy.spring_data_JPA_day_25.model.Student;
import in.nirajarmy.spring_data_JPA_day_25.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent (Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById (Long id) {

        Optional<Student> student = studentRepository.findById(id);

        return student.get();
    }

    public List<Student> getAll(String name) {

        Sort sort = Sort.by("age").ascending()
                .and(Sort.by("name").ascending());

        Pageable pageable = PageRequest.of(0, 3);

        Page<Student> studentList = studentRepository.findAll(pageable);

        for (Student student : studentList.getContent()) {
            System.out.println(student);
        }

        return studentList.getContent();
    }
}
