package com.docker_spring_cloud.notification_service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notif")
public class NotificationController {

    @GetMapping
    public String getNotif(){
        return "notification-service running v3";
    }

}
