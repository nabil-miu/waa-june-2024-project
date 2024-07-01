package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.AcademicResource;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends ListCrudRepository<AcademicResource, Long> {
    void deleteAcademicResourceByName(String filename);
}
