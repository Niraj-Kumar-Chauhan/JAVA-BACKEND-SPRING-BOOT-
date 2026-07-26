package in.nirajarmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private PaymentService payment;

//    OrderService(PaymentService payment) {
//        this.payment = payment;
//    }

    public void OrderPlaced () {
        payment.pay();
        orderDetail();
        System.out.println("Order Placed");
    }

    public void orderDetail () {
        System.out.println("Order Details");
    }
}
