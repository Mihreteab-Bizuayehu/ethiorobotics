package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Notification;
import com.ethioroborobotics.robotics.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NotificationService {

    public final NotificationRepository notificationRepository;

    public Notification addNotification(Notification notification){
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Integer notificationId){
        return notificationRepository.findById(notificationId);
    }

    public Optional<Notification> updateNotification(Integer notificationId,Notification notification){
        return notificationRepository.findById(notificationId).map(update->{

            update.setNotificationType(notification.getNotificationType());
            update.setMessage(notification.getMessage());
            update.setIsActive(notification.getIsActive());

            return notificationRepository.save(update);
        });
    }

    public void deleteNotification(Integer notificationId){
        notificationRepository.deleteById(notificationId);
    }

}
