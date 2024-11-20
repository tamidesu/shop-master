package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.NotificationDTO;
import java.util.List;

public interface NotificationService {

    NotificationDTO createNotification(NotificationDTO notificationDTO);

    NotificationDTO getNotificationById(Long id);

    List<NotificationDTO> getAllNotifications();

    List<NotificationDTO> getNotificationsByUserId(Long userId);

    void markAsRead(Long notificationId);
}
