package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Notification;
import com.ethioroborobotics.robotics.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/add")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        Notification saved=notificationService.addNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications(){
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<Optional<Notification>> getNotificationById(@PathVariable("id") Integer notificationId){
        Optional<Notification> notification=notificationService.getNotificationById(notificationId);
        return ResponseEntity.status(HttpStatus.OK).body(notification);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Optional<Notification>>updateNotification(@PathVariable("id") Integer notificationId,@RequestBody Notification notification){
        Optional<Notification> updated=notificationService.updateNotification(notificationId,notification);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable("id") Integer notificationId){
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok("Notification is deleted successfully!");
    }

}
