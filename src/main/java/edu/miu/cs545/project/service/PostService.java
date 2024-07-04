package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

public interface PostService extends CrudService<Post,Long>{
    Page<Post> findAllPost(Integer page, Integer size, String sortDirection);

    Page<Post> findParentPostByThread(Long id, Integer page, Integer size, String sortDirection);

    Page<Post> findChildPostByParentPost(Long id, Integer page, Integer size, String sortDirection);

    Page<Post> getSearchPosts(String postContent, LocalDate createdAt, LocalDate updatedAt, Pageable pageable);
}
