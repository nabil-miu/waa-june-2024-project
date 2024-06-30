package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.service.StudentDirectoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students-directory")
@Tag(name = "Students Directory", description = "Students Directory API")
public class StudentDirectoryController extends CrudController<StudentDirectory, Long> {

    public StudentDirectoryController(StudentDirectoryService service) {
        super(service);
    }
}
