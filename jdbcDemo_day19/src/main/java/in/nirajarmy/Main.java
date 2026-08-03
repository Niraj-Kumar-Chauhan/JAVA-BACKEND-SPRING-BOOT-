package in.nirajarmy;

import in.nirajarmy.model.Student;
import in.nirajarmy.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, JDBC DEMO...");

        StudentRepository studentRepository = new StudentRepository();

//        studentRepository
//                .createStudent(new Student(
//                        "sanjana",
//                        "sanjana@gmail.com",
//                        15
//                ));

//        studentRepository.updateStudent(
//                new Student(
//                        "rohit negi",
//                        "rohitnegi@gmail.com",
//                        26), 4L
//        );


//        studentRepository.deleteStudent(7L);

//        studentRepository.getStudentById(6L);

        studentRepository.getStudents();
    }
}