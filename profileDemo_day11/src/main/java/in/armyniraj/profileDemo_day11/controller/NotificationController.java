package in.armyniraj.profileDemo_day11.controller;

import in.armyniraj.profileDemo_day11.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notification) {
        this.notificationService = notification;
    }
    @PostMapping
    public ResponseEntity<String> sendNotification () {
        String notification = notificationService.send();

        return ResponseEntity.ok(notification);
    }
}
