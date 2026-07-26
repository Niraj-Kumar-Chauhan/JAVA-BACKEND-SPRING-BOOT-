package in.nirajarmy;


import org.springframework.stereotype.Component;


public class OrderService {

    public OrderService () {
        System.out.println("OrderService Created");
    }
    public void placeOrder () {
        System.out.println("Order Placed");
    }
}
