package in.nirajarmy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Scope("prototype")
public class PaymentService {

    OrderService orderService;

    public  PaymentService ( OrderService orderService) {
        this.orderService = orderService;
//        System.out.println("Payment Service Created");
    }

    public void pay () {
        System.out.println("Payment successful");

        orderService.orderDetails();
    }
}
