package nc.example.notifications;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Notification sent to email");
    }
}
