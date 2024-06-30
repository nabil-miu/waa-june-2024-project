package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.ThreadPost;
import edu.miu.cs545.project.service.ThreadPostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thread-posts")
@Tag(name = "ThreadPost", description = "Thread Post API")
public class ThreadPostController extends CrudController<ThreadPost,Long>{
    public ThreadPostController(ThreadPostService service) {
        super(service);
    }
}
