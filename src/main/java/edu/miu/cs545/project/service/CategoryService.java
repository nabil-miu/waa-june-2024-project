package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.ResourceCategory;

import java.util.List;

public interface CategoryService extends CrudService<ResourceCategory, Long> {

    List<ResourceCategory> getRootCategoriesWithSubcategories();

}
