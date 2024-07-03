package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.ThreadPost;
import edu.miu.cs545.project.service.ThreadPostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thread-posts")
@Tag(name = "ThreadPost", description = "Thread Post API")
public class ThreadPostController extends CrudController<ThreadPost,Long>{
    public ThreadPostController(ThreadPostService service) {
        super(service);
    }

    @Autowired
    private ThreadPostService threadPostService;

    @GetMapping("/pagination")
    public Page<ThreadPost> getAllThreadPagination(@RequestParam(value = "page", required = false) Integer page ,
                                              @RequestParam(value = "size", required = false) Integer size,
                                              @RequestParam(defaultValue = "asc") String sortDirection){
        if(null == page) page = 0;
        if(null == size) size = 10;
        return threadPostService.findAllThread(page,size,sortDirection);
    }
}
