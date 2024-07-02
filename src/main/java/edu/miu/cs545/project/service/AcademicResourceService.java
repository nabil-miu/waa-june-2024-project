package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.AcademicResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcademicResourceService extends CrudService<AcademicResource, Long> {

    List<AcademicResource> getResourcesByCategoryId(Long id);

}
