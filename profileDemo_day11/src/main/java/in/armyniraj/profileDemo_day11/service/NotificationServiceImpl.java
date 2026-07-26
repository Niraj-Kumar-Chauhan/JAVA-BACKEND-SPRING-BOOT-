package in.armyniraj.profileDemo_day11.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceImpl implements NotificationService{

    @Override
    public String send() {

        // Here send real (email/sms) notification

        return "Here is a notification";
    }
}
