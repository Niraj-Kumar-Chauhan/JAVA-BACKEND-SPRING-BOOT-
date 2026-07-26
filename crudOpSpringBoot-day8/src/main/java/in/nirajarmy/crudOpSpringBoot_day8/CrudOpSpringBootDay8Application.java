package in.nirajarmy.crudOpSpringBoot_day8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudOpSpringBootDay8Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudOpSpringBootDay8Application.class, args);
		System.out.println("Hello Niraj Chauhan");
//		System.out.println("SQL_DB_PASSWORD: "+ System.getenv("SQL_DB_PASSWORD"));
	}

}
