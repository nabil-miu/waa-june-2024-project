package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.ThreadPost;
import edu.miu.cs545.project.service.ThreadPostService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thread-posts")
@Tag(name = "ThreadPost", description = "Thread Post API")
public class ThreadPostController extends CrudController<ThreadPost, Long> {

    private final ThreadPostService threadPostService;

    public ThreadPostController(ThreadPostService threadPostService, MeterRegistry registry) {
        super(threadPostService, registry);
        this.threadPostService = threadPostService;
    }

    @GetMapping("/category")
    public Page<ThreadPost> getThreadPostByCategory(@RequestParam(value = "id", required = true) Long id,
                                                    @RequestParam(value = "page", required = false) Integer page,
                                                    @RequestParam(value = "size", required = false) Integer size,
                                                    @RequestParam(defaultValue = "asc") String sortDirection) {
        if (page == null) page = 0;
        if (size == null) size = 10;
        return threadPostService.findThreadPostByCategory(id, page, size, sortDirection);
    }

    @GetMapping("/pagination")
    public Page<ThreadPost> getAllThreadPagination(@RequestParam(value = "page", required = false) Integer page,
                                                   @RequestParam(value = "size", required = false) Integer size,
                                                   @RequestParam(defaultValue = "asc") String sortDirection) {
        if (page == null) page = 0;
        if (size == null) size = 10;
        return threadPostService.findAllThread(page, size, sortDirection);
    }
}
