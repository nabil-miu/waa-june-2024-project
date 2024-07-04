package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.ThreadPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadPostRepository extends GenericRepo<ThreadPost, Long> {

    List<ThreadPost> findThreadPostsByTitleLike(String threadTitle);

}