package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Report;
import edu.miu.cs545.project.service.AdminService;
import edu.miu.cs545.project.service.ModerationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@Tag(name = "Admin", description = "Admin API")
public class AdminController {
    private final AdminService adminService;
    private final ModerationService moderationService;

    public AdminController(AdminService service, ModerationService moderationService) {
        this.adminService = service;
        this.moderationService = moderationService;
    }

    @PostMapping("/deactivate-user")
    public ResponseEntity<Void> deactivateUser(Long id) {
        adminService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/activate-user")
    public ResponseEntity<Void> activateUser(Long id) {
        adminService.activateUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getReports() {
        List<Report> reports = moderationService.getAll();
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/reports/{reportId}")
    public ResponseEntity<Report> getReport(@PathVariable Long reportId) {
        return ResponseEntity.ok(moderationService.getById(reportId).orElse(null));
    }

    @GetMapping("/reports-by-user/{userId}")
    public ResponseEntity<List<Report>> getReportByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(moderationService.getReportsByUser(userId));
    }
}
