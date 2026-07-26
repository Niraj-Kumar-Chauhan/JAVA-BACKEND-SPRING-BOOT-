package com.example.SpringBootCoreDemo_day7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateWay {

//    @Value("${paymentGateWay.type:RazorPay}")
//    private String type;
//
//    @Value("${paymentGateWay.retry-count:3}")
//    private int retryCount;

//    public PaymentGateWay (
//            @Value("${paymentGateWay.type}") String type,
//            @Value("${paymentGateWay.retry-count}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

    private PaymentProperties paymentProperties;

    public PaymentGateWay (PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType () {
        return paymentProperties.getType();
    }

    public int getRetryCount () {
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled () {
        return paymentProperties.isEnabled();
    }

    public int getTimeout () {
        return paymentProperties.getTimeout();
    }

    public void print () {
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(isEnabled());
        System.out.println(getTimeout());
    }
}
