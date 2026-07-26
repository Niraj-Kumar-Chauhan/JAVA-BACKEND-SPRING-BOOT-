package com.example.SpringBootCoreDemo_day7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreDemoDay7Application {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(SpringBootCoreDemoDay7Application.class, args);


//		PaymentGateWay payment = context.getBean(PaymentGateWay.class);
//
//		payment.print();
	}

}
