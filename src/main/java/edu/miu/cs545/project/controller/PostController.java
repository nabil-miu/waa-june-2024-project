package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.dto.ReportRequestDto;
import edu.miu.cs545.project.model.entity.Post;
import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.service.BlockService;
import edu.miu.cs545.project.service.ModerationService;
import edu.miu.cs545.project.service.PostService;
import edu.miu.cs545.project.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/posts")
@Tag(name = "Posts", description = "Posts API")
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


    @GetMapping("/pagination")
    public Page<Post> getAllPostPagination(@RequestParam(value = "page", required = false) Integer page,
                                           @RequestParam(value = "size", required = false) Integer size,
                                           @RequestParam(defaultValue = "asc") String sortDirection) {
        if (null == page) page = 0;
        if (null == size) size = 10;
        return postService.findAllPost(page, size, sortDirection);
    }


    @GetMapping("/thread-post")
    public Page<Post> getParentPostByThreadPost(@RequestParam(value = "id", required = true) Long id,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "size", required = false) Integer size,
                                                @RequestParam(defaultValue = "asc") String sortDirection) {
        if (page == null) page = 0;
        if (size == null) size = 10;
        return postService.findParentPostByThread(id, page, size, sortDirection);
    }

    @GetMapping("/parent-post")
    public Page<Post> getChildPostByParentPost(@RequestParam(value = "id", required = true) Long id,
                                               @RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "size", required = false) Integer size,
                                               @RequestParam(defaultValue = "asc") String sortDirection) {
        if (page == null) page = 0;
        if (size == null) size = 10;
        return postService.findChildPostByParentPost(id, page, size, sortDirection);
    }


    @GetMapping("/search-posts")
    public Page<Post> getSearchPosts(
            @RequestParam(required = false) String postContent,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdAt,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate updatedAt,
            Pageable pageable) {
        return postService.getSearchPosts(postContent, createdAt, updatedAt, pageable);
    }
}
