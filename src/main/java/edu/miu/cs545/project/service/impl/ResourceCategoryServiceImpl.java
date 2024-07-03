package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.ResourceCategory;
import edu.miu.cs545.project.repository.ResourceCategoryRepo;
import edu.miu.cs545.project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceCategoryServiceImpl extends CrudServiceImpl<ResourceCategory, Long> implements CategoryService {

    private final ResourceCategoryRepo repository;

    public ResourceCategoryServiceImpl(ResourceCategoryRepo repository) {
        super(repository);
        this.repository = repository;
    }

    public List<ResourceCategory> getRootCategories() {
        return repository.findByParentIsNull();
    }

    private void loadSubcategories(ResourceCategory category) {
        if (category.getCategoryList() != null) {
            for (ResourceCategory subcategory : category.getCategoryList()) {
                loadSubcategories(subcategory);
            }
        }
    }

    @Override
    public List<ResourceCategory> getRootCategoriesWithSubcategories() {
        List<ResourceCategory> rootCategories = getRootCategories();
        for (ResourceCategory rootCategory : rootCategories) {
            loadSubcategories(rootCategory);
        }
        return rootCategories;
    }
}
