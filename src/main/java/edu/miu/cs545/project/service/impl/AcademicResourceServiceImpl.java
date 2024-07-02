package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.AcademicResource;
import edu.miu.cs545.project.model.entity.ResourceCategory;
import edu.miu.cs545.project.repository.ResourceRepo;
import edu.miu.cs545.project.service.AcademicResourceService;
import edu.miu.cs545.project.service.CategoryService;

import java.util.List;

public class AcademicResourceServiceImpl extends CrudServiceImpl<AcademicResource, Long> implements AcademicResourceService {

    private final ResourceRepo resourceRepo;
    private final CategoryService categoryService;

    public AcademicResourceServiceImpl(ResourceRepo repository, CategoryService categoryService) {
        super(repository);
        resourceRepo = repository;
        this.categoryService = categoryService;
    }

    @Override
    public List<AcademicResource> getResourcesByCategoryId(Long id) {
        ResourceCategory category = categoryService.getById(id).orElseThrow();
        return resourceRepo.findAllByResourceCategory(category);
    }
}
