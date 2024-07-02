package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Post;
import edu.miu.cs545.project.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@Tag(name = "Post", description = "Post API")
public class PostController extends CrudController<Post,Long>{
    public PostController(PostService postService){
        super(postService);
    }
}
