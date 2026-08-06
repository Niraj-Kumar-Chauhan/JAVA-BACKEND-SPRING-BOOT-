package in.nirajarmy.springJDBC_Demo_day20.repository;

import in.nirajarmy.springJDBC_Demo_day20.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

//    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    private RowMapper<Student> rowMapper =
            new BeanPropertyRowMapper<>(Student.class);

    private JdbcTemplate jdbcTemplate;

    public StudentRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createStudent(Student student) {

//        System.out.println("SQL_DB_PASSWORD : " + sqlPassword);

        String sqlQuery = """
                INSERT INTO students(name, email, age)
                VALUES (?, ?, ?)
                """;

        int rowAffected = jdbcTemplate.update(
                sqlQuery,
                student.getName(),
                student.getEmail(),
                student.getAge()
        );

        if (rowAffected == 1) {
            System.out.println("student create successful");
        } else {
            System.out.println("student Create failed");
        }
    }

    public void updateStudent(Student student, Long id) {

        String sqlQuery = """
                 UPDATE students
                 SET name = ?,
                     email = ?,
                     age = ?
                 WHERE id = ?
                """;

        int rowAffected = jdbcTemplate.update(
                sqlQuery,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getId()
        );

        if (rowAffected == 1) {
            System.out.println("student update successful");
        } else {
            System.out.println("student updation failed");
        }

    }

    public void deleteStudent(Long id) {

        String sqlQuery = """
                    DELETE  FROM students WHERE id = ?
                """;

        int rowAffected = jdbcTemplate.update(sqlQuery, id);

        if (rowAffected == 1) {
            System.out.println("student deleted successfully");
        } else {
            System.out.println("student Deletion failed");
        }

    }

    public Student getStudentById(Long id) {

        String sqlQuery = """
                    SELECT id, name, email, age
                    FROM students WHERE id = ?
                """;

        Student student = jdbcTemplate.queryForObject(
                sqlQuery,
                rowMapper,
                id
        );

        return student;
    }


    public List<Student> getStudents() {

        String sqlQuery = """
                    SELECT id, name, email, age FROM students
                """;

        List<Student> students = jdbcTemplate.query(
                sqlQuery,
                rowMapper
        );

        return  students;
    }


    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }
}
