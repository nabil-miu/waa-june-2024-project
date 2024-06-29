package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Category;
import edu.miu.cs545.project.repository.CategoryRepo;
import edu.miu.cs545.project.service.CategoryService;
import edu.miu.cs545.project.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category, Long> implements CategoryService {

    public CategoryServiceImpl(CategoryRepo repository) {
        super(repository);
    }
}
