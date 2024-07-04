package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Post;
import edu.miu.cs545.project.model.entity.ThreadPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Page<Post> findByParentPostIsNull(Pageable pageable);

    Page<Post> findByThreadPostAndParentPostIsNull(ThreadPost threadPost, Pageable pageable);

    Page<Post> findByParentPost(Post post, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE (:content IS NULL OR p.content LIKE %:content%) AND (:createdAt IS NULL OR DATE(p.createdAt) = :createdAt) AND (:updatedAt IS NULL OR DATE(p.updatedAt) = :updatedAt) AND p.parentPost IS NULL")
    Page<Post> findByContentAndCreatedAtAndUpdatedAtAndParentPostIsNull(@Param("content") String content, @Param("createdAt") LocalDate createdAt, @Param("updatedAt") LocalDate updatedAt, Pageable pageable);

}
