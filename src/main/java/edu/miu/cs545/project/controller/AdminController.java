package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@Tag(name = "Admin", description = "Admin API")
public class AdminController extends CrudController<User, Long>{
    private final AdminService adminService;
    public AdminController(AdminService service) {
        super(service);
        this.adminService = service;
    }

    @PostMapping("/deactivate-user")
    public ResponseEntity<Void> deactivateUser(Long id) {
        adminService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }
}
