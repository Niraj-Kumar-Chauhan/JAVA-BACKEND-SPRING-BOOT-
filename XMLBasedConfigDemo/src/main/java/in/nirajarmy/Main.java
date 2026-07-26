package in.nirajarmy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get Bean by id/name
        //OrderService orderService = (OrderService) context.getBean("orderService");

        // Get Bean by type
        //OrderService orderService = context.getBean(OrderService.class);

        OrderService orderService =
                context.getBean("orderServiceBean", OrderService.class);
        PaymentService payment =
                context.getBean("paymentService", PaymentService.class);
        payment.pay();
        orderService.placeOrder();
    }
}
