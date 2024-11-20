package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.AuditLogDTO;
import java.util.List;

public interface AuditLogService {

    AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO);

    AuditLogDTO getAuditLogById(Long id);

    List<AuditLogDTO> getAllAuditLogs();

    List<AuditLogDTO> getAuditLogsByUserId(Long userId);

}

