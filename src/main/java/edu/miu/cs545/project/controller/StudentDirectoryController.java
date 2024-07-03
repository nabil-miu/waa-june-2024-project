package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.dto.StudentDirectoryDTO;
import edu.miu.cs545.project.mapper.impl.StudentDirectoryMapper;
import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.service.StudentDirectoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<StudentDirectoryDTO>> searchByLastName(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate academicyear,
                                                                      @RequestParam(required = false) String major,
                                                                      @RequestParam(required = false) String text) {

        List<StudentDirectory> students = studentDirectoryService.findByAcademicYearAndMajorAndOtherFilters(academicyear,major,text);
       return ResponseEntity.ok().body(StudentDirectoryMapper.toStudentDirectoryDTOList(students));
    }
}
