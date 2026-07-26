package in.nirajarmy.dtoDemo_day9.service;

import in.nirajarmy.dtoDemo_day9.dto.CreateStudentRequestDto;
import in.nirajarmy.dtoDemo_day9.dto.CreateStudentResponseDto;
import in.nirajarmy.dtoDemo_day9.dto.UpdateStudentRequestDto;
import in.nirajarmy.dtoDemo_day9.dto.UpdateStudentResponseDto;
import in.nirajarmy.dtoDemo_day9.entity.Student;
import in.nirajarmy.dtoDemo_day9.repository.StudentRepository;
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
    ) {
        //business logic
        Student student = mapToCreateEntity(studentReqtDto);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        //store in DB
        Student studentRes = studentRepository.save(student);

        return mapToCreateDto(studentRes);
    }

    public CreateStudentResponseDto getOneStudent (Long id) {
        Optional<Student> student =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(student.isEmpty()){
            return null;
        }
        Student studentRes = student.get();
        CreateStudentResponseDto mapTocreateDto = mapToCreateDto(studentRes);
        mapTocreateDto.setMessage("student fetched successfully");

        return mapTocreateDto;
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
        Optional<Student> student =
                studentRepository.findByIdAndDeletedIsFalse(id);
        System.out.println("In update method of stService: " + student);
        if (student.isEmpty()){
            return null;
        }
        Student studentToSave = student.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student studentRes = studentRepository.save(studentToSave);

        UpdateStudentResponseDto updateStudentResponseDto =
                mapToUpdateDto(studentRes);

        return updateStudentResponseDto;
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

    private Student mapToCreateEntity (CreateStudentRequestDto studentReqDto) {
        Student student = new Student();

        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setSubject(studentReqDto.getSubject());
        student.setRollNo(studentReqDto.getRollNo());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDto mapToCreateDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
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

}
