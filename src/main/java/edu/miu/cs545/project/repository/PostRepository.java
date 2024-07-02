package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Post;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ListCrudRepository<Post,Long> {
}
