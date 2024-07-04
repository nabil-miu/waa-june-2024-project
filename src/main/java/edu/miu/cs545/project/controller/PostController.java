package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.dto.ReportRequestDto;
import edu.miu.cs545.project.model.entity.Post;
import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.service.BlockService;
import edu.miu.cs545.project.service.ModerationService;
import edu.miu.cs545.project.service.PostService;
import edu.miu.cs545.project.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
@Tag(name = "Post", description = "Post API")
public class PostController extends CrudController<Post, Long> {
    private final ModerationService moderationService;
    private final PostService postService;
    private final UserService userService;
    private final BlockService blockService;

    public PostController(ModerationService moderationService, PostService postService, UserService userService, BlockService blockService) {
        super(postService);
        this.moderationService = moderationService;
        this.postService = postService;
        this.userService = userService;
        this.blockService = blockService;
    }

    @PostMapping("/{postId}/report")
    public ResponseEntity<String> reportPost(@PathVariable Long postId, @RequestBody ReportRequestDto reportRequest) {
        Optional<User> reporter = userService.getById(reportRequest.getReporterId());

        Post post = postService.getById(postId).orElse(null);
        moderationService.reportPost(reporter.orElse(null), post, reportRequest.getReason());
        return ResponseEntity.ok("Post reported successfully");
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Post>> getAllByUserId(@PathVariable Long userId) {
        User user = userService.getById(userId).orElse(null);
        List<User> blockedUsers = blockService.getBlockedUsers(user);
        List<Post> posts = postService.getAll().stream().filter(post -> !blockedUsers.contains(post.getThreadPost().getUser())).toList();
        return ResponseEntity.ok(posts);
    }
}
