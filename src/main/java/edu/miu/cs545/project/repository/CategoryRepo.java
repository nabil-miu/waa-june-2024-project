package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category, Long> {
}
