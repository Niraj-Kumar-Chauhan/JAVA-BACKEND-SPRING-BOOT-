package in.nirajarmy.AOPIntroductionDemo_day15.repository;

import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public void save() {
        System.out.println("student saved");
    }
}
