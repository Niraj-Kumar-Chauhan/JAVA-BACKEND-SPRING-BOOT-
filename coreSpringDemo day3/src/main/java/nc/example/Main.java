package nc.example;

import nc.example.notifications.EmailService;
import nc.example.notifications.NotificationService;
import nc.example.notifications.PopUpNotificationService;
import nc.example.notifications.SmsService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService notification =  new PopUpNotificationService();

//        OrderService order = new OrderService(notification);
        OrderService order = new OrderService();
        order.setNotification(notification);
        order.placeOrder();
    }
}