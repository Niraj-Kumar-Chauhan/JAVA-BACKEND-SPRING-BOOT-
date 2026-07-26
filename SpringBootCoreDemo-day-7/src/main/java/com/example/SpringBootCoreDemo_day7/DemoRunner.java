package com.example.SpringBootCoreDemo_day7;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner /*ApplicationRunner*/ {

    private PaymentGateWay paymentGateWay;

    public DemoRunner (PaymentGateWay paymentGateWay) {
        this.paymentGateWay = paymentGateWay;
    }

    @Override
    public void run(String... args) throws Exception {
        paymentGateWay.print();
    }
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        paymentGateWay.print();
//    }
}
