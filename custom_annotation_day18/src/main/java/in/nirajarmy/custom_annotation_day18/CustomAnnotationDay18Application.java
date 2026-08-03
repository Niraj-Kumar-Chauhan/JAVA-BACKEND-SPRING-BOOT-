package in.nirajarmy.custom_annotation_day18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomAnnotationDay18Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomAnnotationDay18Application.class, args);

		System.out.println("Hello custom pointcuts...");
	}

}
