package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.AuditLogDTO;
import kz.com.alzhan.temirlan.services.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/{id}")
    public AuditLogDTO getAuditLogById(@PathVariable Long id) {
        return auditLogService.getAuditLogById(id);
    }

    @GetMapping("/")
    public List<AuditLogDTO> getAllAuditLogs() {
        return auditLogService.getAllAuditLogs();
    }

    @GetMapping("/user/{userId}")
    public List<AuditLogDTO> getAuditLogsByUserId(@PathVariable Long userId) {
        return auditLogService.getAuditLogsByUserId(userId);
    }

    @PostMapping("/")
    public AuditLogDTO createAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        return auditLogService.createAuditLog(auditLogDTO);
    }
}
