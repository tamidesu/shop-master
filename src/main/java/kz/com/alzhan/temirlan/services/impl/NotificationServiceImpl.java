package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.NotificationDTO;
import kz.com.alzhan.temirlan.entities.NotificationEntity;
import kz.com.alzhan.temirlan.repositories.NotificationRepository;
import kz.com.alzhan.temirlan.services.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        NotificationEntity notification = modelMapper.map(notificationDTO, NotificationEntity.class);
        NotificationEntity savedNotification = notificationRepository.save(notification);
        return modelMapper.map(savedNotification, NotificationDTO.class);
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
        NotificationEntity notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        return modelMapper.map(notification, NotificationDTO.class);
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        List<NotificationEntity> notifications = notificationRepository.findAll();
        return notifications.stream()
                .map(notif -> modelMapper.map(notif, NotificationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        List<NotificationEntity> notifications = notificationRepository.findByUserId(userId);
        return notifications.stream()
                .map(notif -> modelMapper.map(notif, NotificationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void markAsRead(Long notificationId) {
        NotificationEntity notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}
