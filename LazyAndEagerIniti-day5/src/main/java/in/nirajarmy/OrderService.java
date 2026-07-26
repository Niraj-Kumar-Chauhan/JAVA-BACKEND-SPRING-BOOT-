package in.nirajarmy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope("prototype")
public class OrderService {

    PaymentService payment;

    public  OrderService (@Lazy PaymentService payment) {
        this.payment = payment;
//        System.out.println("Order Service Created");
    }

    public void placeOrder () {
        payment.pay();

        System.out.println("Order placed");
    }

    public void orderDetails () {
        System.out.println("Order Details");
    }
}
