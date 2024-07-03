package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.AcademicResource;
import edu.miu.cs545.project.model.entity.ResourceCategory;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepo extends ListCrudRepository<AcademicResource, Long> {
    void deleteAcademicResourceByName(String filename);
    List<AcademicResource> findAllByResourceCategory(ResourceCategory category);
}
