package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.ThreadPost;
import org.springframework.data.domain.Page;

public interface ThreadPostService extends CrudService<ThreadPost, Long> {
    Page<ThreadPost> findAllThread(Integer page, Integer size, String sortDirection);
    Page<ThreadPost> findThreadPostByCategory(Long id, Integer page, Integer size,String sortDirection);
}