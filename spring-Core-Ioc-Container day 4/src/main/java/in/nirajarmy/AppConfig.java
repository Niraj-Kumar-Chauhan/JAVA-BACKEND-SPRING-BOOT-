package in.nirajarmy;

import in.nirajarmy.payment.CardPayment;
import in.nirajarmy.payment.PaymentService;
import in.nirajarmy.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("in.nirajarmy")
public class AppConfig {
    @Bean
    public User createUser () {
        return new User("Niraj Chauhan", 23);
    }

    @Bean
    @Qualifier("cap")
    public PaymentService createCardPayment () {
        return new CardPayment();
    }

    @Bean
    @Qualifier("upip")
    public PaymentService createUpiPayment () {
        return new UpiPayment();
    }
    @Bean
    public OrderService createOrder (@Qualifier("cap") PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
