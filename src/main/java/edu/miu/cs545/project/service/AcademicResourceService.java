package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.AcademicResource;

import java.util.List;

public interface AcademicResourceService extends CrudService<AcademicResource, Long> {

    List<AcademicResource> getResourcesByCategoryId(Long id);

}
