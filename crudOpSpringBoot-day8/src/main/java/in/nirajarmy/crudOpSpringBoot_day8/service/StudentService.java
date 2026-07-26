package in.nirajarmy.crudOpSpringBoot_day8.service;

import in.nirajarmy.crudOpSpringBoot_day8.entity.Student;
import in.nirajarmy.crudOpSpringBoot_day8.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent (Student studentReq) {
        //business logic

        //store in DB
        Student studentRes = studentRepository.save(studentReq);

        return studentRes;
    }

    public Student getOneStudent (Long id) {
        Optional<Student> studentRes =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentRes.isPresent()){
            return studentRes.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList =
                studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public Student updateStudent (Long id, Student studentReq) {
        Optional<Student> isExistStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if (isExistStudent.isEmpty()){
            return null;
        }

        Student studentToSave = isExistStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
        boolean isExistStudent = studentRepository.existsById(id);

        if (!isExistStudent) return false;

        studentRepository.deleteById(id);

        return true;
    }

    public Boolean deleteAllStudent () {
        List<Student> isStudents = studentRepository.findAll();

        if (isStudents.isEmpty()){
            return false;
        }
        studentRepository.deleteAll();

        return true;
    }

    public Boolean deleteStudentSoftly (Long id) {
        Optional<Student> isExistStudent  =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if (isExistStudent.isEmpty()){
            return false;
        }

        Student studentToSave = isExistStudent.get();
        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);

        return true;
    }

    public List<Student> getAllSoftlyDeletedStudent() {
        List<Student> getSoftDeletedStudents =
                studentRepository.findByDeletedIsTrue();

        return getSoftDeletedStudents;
    }

    public Boolean deleteSoftlyAllStudent () {
        List<Student> studentList =
                studentRepository.findByDeletedIsFalse();

        if (studentList.isEmpty()){
            return null;
        }

        for (Student student: studentList) {
            student.setDeleted(true);
        }
        studentRepository.saveAll(studentList);

        return true;
    }

    public Boolean deleteAllSoftlyDeletedStudent () {
        List<Student> studentList = studentRepository.findByDeletedIsTrue();

        if (studentList.isEmpty()){
            return null;
        }

        studentRepository.deleteAll(studentList);

        return true;
    }

}
