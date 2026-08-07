package in.nirajarmy.HibernateDemo_day21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoDay21Application {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoDay21Application.class, args);

		System.out.println("Hello, Hibernate-> JDBC ...");
	}

}
