package in.nirajarmy;

import in.nirajarmy.payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {

//    @Autowired
    private PaymentService payment;

//    @Autowired
    OrderService(PaymentService payment) {
        this.payment = payment;
    }

//    @Autowired
//    public void setPayment(PaymentService payment) {
//        this.payment = payment;
//    }

    void orderPlace() {
        payment.pay();
        System.out.println("Order placed");
    }
}
