package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.ResourceCategory;
import edu.miu.cs545.project.service.CategoryService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Categories", description = "Categories API")
public class CategoryController extends CrudController<ResourceCategory, Long> {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService, MeterRegistry registry) {
        super(categoryService, registry);
        this.categoryService = categoryService;
    }

    @GetMapping("/root")
    public List<ResourceCategory> getRootCategoriesWithSubcategories() {
        return categoryService.getRootCategoriesWithSubcategories();
    }
}
