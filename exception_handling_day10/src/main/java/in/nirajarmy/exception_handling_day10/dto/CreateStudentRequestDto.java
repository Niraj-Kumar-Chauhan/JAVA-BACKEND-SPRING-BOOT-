package in.nirajarmy.exception_handling_day10.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = "name cannot be null/empty or blank")
    @Size(min = 2, max = 50,
            message = "name must be within 2 to 50 character long")
    private String name;

    @NotNull(message = "age is required")
    @Min(value = 18, message = "student age atleast 18 year old")
    private int age;

    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

    @NotNull(message = "rollNo is required")
    private Integer rollNo;

    @NotBlank(message = "subject is required")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
