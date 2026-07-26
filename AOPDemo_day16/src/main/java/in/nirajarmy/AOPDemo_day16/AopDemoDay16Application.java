package in.nirajarmy.AOPDemo_day16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoDay16Application {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoDay16Application.class, args);

		System.out.println("Hello, Aspect Oriented Programming");
	}

}
