package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.service.StudentDirectoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/search")
@Tag(name = "Search", description = "Searching API")
@RequiredArgsConstructor
public class SearchController {
    private final StudentDirectoryService studentDirectoryService;

    @GetMapping("/majors")
    public ResponseEntity<List<StudentDirectory>> searchByLastName(@PathVariable String major) {
        Optional<List<StudentDirectory>> studentDirectories = studentDirectoryService.findByMajor(major);
        return studentDirectories.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

}
