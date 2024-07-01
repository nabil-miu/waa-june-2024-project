package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.service.StudentDirectoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students-directory")
@Tag(name = "Students Directory", description = "Students Directory API")
public class StudentDirectoryController extends CrudController<StudentDirectory, Long> {

    public StudentDirectoryController(StudentDirectoryService service) {
        super(service);
    }
}
