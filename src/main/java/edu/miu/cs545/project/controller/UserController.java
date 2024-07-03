package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.dto.ReportRequestDto;
import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.service.BlockService;
import edu.miu.cs545.project.service.ModerationService;
import edu.miu.cs545.project.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Users API")
public class UserController extends CrudController<User, Long> {
    private final UserService userService;
    private final ModerationService moderationService;
    private final BlockService blockService;

    public UserController(UserService userService, ModerationService moderationService, BlockService blockService) {
        super(userService);
        this.userService = userService;
        this.moderationService = moderationService;
        this.blockService = blockService;
    }

    @PostMapping("/{userId}/report")
    public ResponseEntity<String> reportUser(@PathVariable Long userId, @RequestBody ReportRequestDto reportRequest) {
        Optional<User> reporter = userService.getById(reportRequest.getReporterId());
        Optional<User> targetUser = userService.getById(userId);
        moderationService.reportUser(reporter.orElse(null), targetUser.orElse(null), reportRequest.getReason());
        return ResponseEntity.ok("User reported successfully");
    }

    @PostMapping("/{blockedId}/block")
    public ResponseEntity<String> blockUser(@PathVariable Long blockedId, @RequestBody User blocker) {
        Optional<User> blocked = userService.getById(blockedId);
        blockService.blockUser(blocker, blocked.orElse(null));
        return ResponseEntity.ok("User blocked successfully");
    }

    @PostMapping("/{blockedId}/unblock")
    public ResponseEntity<String> unblock(@PathVariable Long blockedId, @RequestBody User blocker) {
        Optional<User> blocked = userService.getById(blockedId);
        blockService.unblockUser(blocker, blocked.orElse(null));
        return ResponseEntity.ok("User blocked successfully");
    }
}
