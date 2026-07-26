package nc.example.notifications;

public class PopUpNotificationService implements NotificationService {
    @Override
    public void sendNotification () {
        System.out.println("Pop-up notification sent");
    }
}
