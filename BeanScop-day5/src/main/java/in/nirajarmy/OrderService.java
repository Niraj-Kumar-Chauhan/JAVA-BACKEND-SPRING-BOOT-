package in.nirajarmy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderService {

    public OrderService() {
        System.out.println("OrderService Created");
    }

//    public void orderPlace() {
//        System.out.println("Order Placed");
//    }
}
