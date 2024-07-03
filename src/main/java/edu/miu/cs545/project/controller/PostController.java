package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Post;
import edu.miu.cs545.project.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@Tag(name = "Post", description = "Post API")
public class PostController extends CrudController<Post,Long>{
    public PostController(PostService postService){
        super(postService);
    }

    @Autowired
    private PostService postService;

    @GetMapping("/thread-post")
    public Page<Post> getParentPostByThreadPost(@RequestParam(value = "id", required = true) Long id,
                                                    @RequestParam(value = "page", required = false) Integer page ,
                                                    @RequestParam(value = "size", required = false) Integer size,
                                                    @RequestParam(defaultValue = "asc") String sortDirection){
        if(null == page) page = 0;
        if(null == size) size = 10;
        return postService.findParentPostByThread(id,page,size,sortDirection);
    }

    @GetMapping("/parent-post")
    public Page<Post> getChildPostByParentPost(@RequestParam(value = "id", required = true) Long id,
                                              @RequestParam(value = "page", required = false) Integer page ,
                                              @RequestParam(value = "size", required = false) Integer size,
                                              @RequestParam(defaultValue = "asc") String sortDirection){
        if(null == page) page = 0;
        if(null == size) size = 10;
        return postService.findChildPostByParentPost(id,page,size,sortDirection);
    }
    
}
