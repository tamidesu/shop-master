package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.AuditLogDTO;
import kz.com.alzhan.temirlan.entities.AuditLogEntity;
import kz.com.alzhan.temirlan.repositories.AuditLogRepository;
import kz.com.alzhan.temirlan.services.AuditLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO) {
        AuditLogEntity auditLog = modelMapper.map(auditLogDTO, AuditLogEntity.class);
        AuditLogEntity savedAuditLog = auditLogRepository.save(auditLog);
        return modelMapper.map(savedAuditLog, AuditLogDTO.class);
    }

    @Override
    public AuditLogDTO getAuditLogById(Long id) {
        AuditLogEntity auditLog = auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audit log not found"));
        return modelMapper.map(auditLog, AuditLogDTO.class);
    }

    @Override
    public List<AuditLogDTO> getAllAuditLogs() {
        List<AuditLogEntity> auditLogs = auditLogRepository.findAll();
        return auditLogs.stream()
                .map(log -> modelMapper.map(log, AuditLogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditLogDTO> getAuditLogsByUserId(Long userId) {
        List<AuditLogEntity> auditLogs = auditLogRepository.findByUserId(userId);
        return auditLogs.stream()
                .map(log -> modelMapper.map(log, AuditLogDTO.class))
                .collect(Collectors.toList());
    }
}
