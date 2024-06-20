package com.ve.notify.controllers;

import com.ve.notify.dto.NotificationRequestDto;
import com.ve.notify.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notify")
    public String notifyStudents(@RequestBody NotificationRequestDto request) {
        notificationService.notifyStudents(request);
        return "Notificaciones enviadas";
    }
}