package in.nirajarmy.interceptors_day14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterceptorsDay14Application {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorsDay14Application.class, args);

		System.out.println("Hello, Interceptor session...");
	}

}
