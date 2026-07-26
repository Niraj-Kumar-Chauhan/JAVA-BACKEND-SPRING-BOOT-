package in.nirajarmy.exception_handling_day10.service;

import in.nirajarmy.exception_handling_day10.dto.CreateStudentRequestDto;
import in.nirajarmy.exception_handling_day10.dto.CreateStudentResponseDto;
import in.nirajarmy.exception_handling_day10.dto.UpdateStudentRequestDto;
import in.nirajarmy.exception_handling_day10.dto.UpdateStudentResponseDto;
import in.nirajarmy.exception_handling_day10.entity.Student;
import in.nirajarmy.exception_handling_day10.exception.DuplicateResourceException;
import in.nirajarmy.exception_handling_day10.exception.ResourceNotFoundException;
import in.nirajarmy.exception_handling_day10.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public CreateStudentResponseDto createStudent (
            CreateStudentRequestDto studentReqtDto
    )  {
        //business logic
        Student student = mapToCreateEntity(studentReqtDto);

        if (emailExists(student)){
            throw new DuplicateResourceException
                    ("student with email " + student.getEmail() + " already exist");
        }
        //store in DB
        Student studentRes = studentRepository.save(student);

        return mapToCreateDto(studentRes);
    }

    public CreateStudentResponseDto getOneStudent (Long id) {
        Student studentRes = studentRepository
                .findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException
                                ("student with id " + id + " not found"));

        return mapToCreateDto(studentRes);
    }

    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList =
                studentRepository.findByDeletedIsFalse();
        return studentList.stream()
                .map(this:: mapToCreateDto)
                .toList();
    }

    public UpdateStudentResponseDto updateStudent (
            Long id,
            UpdateStudentRequestDto studentReq
    ) {
        Student isStudentExists =
                studentRepository
                        .findByIdAndDeletedIsFalse(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException
                                        ("student with id " + id + " already exists"));


        isStudentExists.setName(studentReq.getName());
        isStudentExists.setAge(studentReq.getAge());
        isStudentExists.setRollNo(studentReq.getRollNo());
        isStudentExists.setSubject(studentReq.getSubject());

        isStudentExists.setUpdatedAt(LocalDateTime.now());

        Student saveStudent = studentRepository.save(isStudentExists);

        UpdateStudentResponseDto updateStudentResponseDto =
                mapToUpdateDto(saveStudent);

        return updateStudentResponseDto;
    }

    public void deleteStudent(Long id) {
        Student isExistStudent = studentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException
                                        ("student with id " + id + " already exists"));


        studentRepository.delete(isExistStudent);
    }

    public Boolean deleteAllStudent () {
        List<Student> isStudents = studentRepository.findAll();

        if (isStudents.isEmpty()){
            return false;
        }
        studentRepository.deleteAll();

        return true;
    }

    public void deleteStudentSoftly (Long id) {
        Student isExistStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException
                                ("student with id " + id + " already exists"));

        isExistStudent.setDeleted(true);

        studentRepository.save(isExistStudent);

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

    private Student mapToCreateEntity (CreateStudentRequestDto studentReqDto) {
        Student student = new Student();

        student.setName(studentReqDto.getName().trim());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail().trim());
        student.setSubject(studentReqDto.getSubject().trim());
        student.setRollNo(studentReqDto.getRollNo());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDto mapToCreateDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setEmail(student.getEmail());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("student saved successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());


        return responseDto;
    }

    private Student mapToUpdatedEntiry(
            UpdateStudentRequestDto studentReq
    ) {
        Student student = new Student();

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setRollNo(studentReq.getRollNo());
        student.setSubject(studentReq.getSubject());

        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto updatedStudentRes =
                new UpdateStudentResponseDto();

        updatedStudentRes.setId(student.getId());
        updatedStudentRes.setName(student.getName());
        updatedStudentRes.setAge(student.getAge());
        updatedStudentRes.setEmail(student.getEmail());
        updatedStudentRes.setRollNo(student.getRollNo());
        updatedStudentRes.setSubject(student.getSubject());
        updatedStudentRes.setUpdatedAt(student.getUpdatedAt());
        updatedStudentRes.setMessage("student updated successfully");

        return updatedStudentRes;
    }

    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }

}
