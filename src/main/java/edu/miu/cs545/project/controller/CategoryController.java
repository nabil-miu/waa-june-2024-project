package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Category;
import edu.miu.cs545.project.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Categories", description = "Categories API")
public class CategoryController extends CrudController<Category, Long> {

    public CategoryController(CategoryServiceImpl categoryService) {
        super(categoryService);
    }
}
