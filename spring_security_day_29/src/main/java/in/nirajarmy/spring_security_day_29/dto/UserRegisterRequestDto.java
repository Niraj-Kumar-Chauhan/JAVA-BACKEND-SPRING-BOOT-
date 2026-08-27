package in.nirajarmy.spring_security_day_29.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDto {

    private String username;

    private String password;
}
