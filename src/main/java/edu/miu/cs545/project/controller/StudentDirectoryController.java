package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.service.StudentDirectoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students-directory")
@Tag(name = "Students Directory", description = "Students Directory API")
public class StudentDirectoryController extends CrudController<StudentDirectory, Long> {
    private final StudentDirectoryService studentDirectoryService;
    public StudentDirectoryController(StudentDirectoryService service) {
        super(service);
        this.studentDirectoryService = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentDirectory>> searchByLastName(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate academicyear,
                                                                   @RequestParam(required = false) String major,
                                                                   @RequestParam(required = false) String text) {

        List<StudentDirectory> students = studentDirectoryService.findByAcademicYearAndMajorAndOtherFilters(academicyear,major,text);
        return ResponseEntity.ok().body(students);
    }
    @GetMapping("/pages/{page}")
    public ResponseEntity<Page<StudentDirectory>> getPage(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        if (size == null) {
            size = 10;
        }
        if (page == null) {
            page = 0;
        }

        Page<StudentDirectory> studentDirectoriesPage = studentDirectoryService.getStudentDirectoryByPage(page, size);
        return ResponseEntity.ok().body(studentDirectoriesPage);
    }
}
