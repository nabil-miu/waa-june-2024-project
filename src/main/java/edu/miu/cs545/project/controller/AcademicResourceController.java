package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.AcademicResource;
import edu.miu.cs545.project.service.AcademicResourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
@Tag(name = "AcademicResources", description = "Academic Resources API")
public class AcademicResourceController extends CrudController<AcademicResource, Long> {

    private final AcademicResourceService service;

    public AcademicResourceController(AcademicResourceService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/category")
    public ResponseEntity<List<AcademicResource>> getResourcesByCategory(Long id) {
        List<AcademicResource> resources = service.getResourcesByCategoryId(id);
        return ResponseEntity.ok(resources);
    }
}