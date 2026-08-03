package in.nirajarmy.repository;

import in.nirajarmy.model.Student;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/learn_jdbc_student_db";
    String sqlUserName = "root";
    String sqlPassword = System.getenv("SQL_DB_PASSWORD");


    public void createStudent(Student student) {

//        System.out.println("SQL_DB_PASSWORD : " + sqlPassword);

        String sqlQuery = """
                INSERT INTO students(name, email, age) 
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(url, sqlUserName, sqlPassword);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlQuery);
        ) {

            System.out.println("Database Connected Successfully");

//            Statement statement = connection.createStatement();

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                System.out.println("create student successful");
            } else {
                System.out.println("Create student failed");
            }

        } catch (SQLException e) {
            System.out.println("Database Connection failed");

            e.printStackTrace();
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

        try (
                Connection connection =
                        DriverManager.getConnection(url, sqlUserName, sqlPassword);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlQuery);
        ) {

            System.out.println("Database Connected Successfully");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                System.out.println("update operation successful");
            } else {
                System.out.println("updation failed");
            }

        } catch (SQLException e) {
            System.out.println("Database Connection failed");

            e.printStackTrace();
        }

    }

    public void deleteStudent(Long id) {

        String sqlQuery = """
                    DELETE  FROM students WHERE id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(url, sqlUserName, sqlPassword);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlQuery);
        ) {

            System.out.println("Database Connected Successfully");

            preparedStatement.setLong(1, id);

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                System.out.println("delete operation successful");
            } else {
                System.out.println("Deletion failed");
            }

        } catch (SQLException e) {
            System.out.println("Database Connection failed");

            e.printStackTrace();
        }
    }

    public void getStudentById(Long id) {

        String sqlQuery = """
                    SELECT id, name, email, age
                    FROM students WHERE id = ?
                """;
        try (
                Connection connection =
                        DriverManager.getConnection(url, sqlUserName, sqlPassword);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlQuery);
        ) {

            System.out.println("Database Connected Successfully");

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()) {
                    Student student = mapRow(resultSet);

                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Connection failed");

            e.printStackTrace();
        }
    }


    public void getStudents() {

        String sqlQuery = """
                    SELECT id, name, email, age FROM students
                """;
        try (
                Connection connection =
                        DriverManager.getConnection(url, sqlUserName, sqlPassword);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlQuery);
        ) {

            System.out.println("Database Connected Successfully");

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    Student student = mapRow(resultSet);

                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Connection failed");

            e.printStackTrace();
        }
    }

    public void completeCRUD() {

        try {
            Connection connection =
                    DriverManager.getConnection(url, sqlUserName, sqlPassword);

            System.out.println("Database Connected Successfully");

            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT id, name, email, age " +
                    "FROM students WHERE id = 3";

            boolean result = statement.execute(sqlQuery);

            if (result) {
                ResultSet resultSet = statement.getResultSet();
            } else {
                int rowAffected = statement.getUpdateCount();
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database Connection failed");

            e.printStackTrace();
        }
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
