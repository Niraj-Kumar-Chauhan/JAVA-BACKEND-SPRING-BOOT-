package nc.example;

import nc.example.notifications.EmailService;
import nc.example.notifications.NotificationService;
import nc.example.notifications.PopUpNotificationService;
import nc.example.notifications.SmsService;

public class OrderService {

    NotificationService notification;
    OrderService(NotificationService notification) {
        this.notification = notification;
    }

    OrderService() {

    }
    public void placeOrder() {
        System.out.println("Order placed");
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
