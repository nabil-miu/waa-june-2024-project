package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.dto.StudentDirectoryDTO;
import edu.miu.cs545.project.mapper.impl.StudentDirectoryMapper;
import edu.miu.cs545.project.mapper.impl.UserDtoMapper;
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


    @GetMapping("/major/{major}")
    public ResponseEntity<List<StudentDirectoryDTO>> searchByMajor(@PathVariable String major) {
        Optional<List<StudentDirectory>> studentDirectories = studentDirectoryService.findByMajor(major);
        return studentDirectories.map(directories ->
                ResponseEntity.ok(StudentDirectoryMapper.toStudentDirectoryDTOList(directories))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/academicyear/{academicyear}")
    public ResponseEntity<List<StudentDirectoryDTO>> searchByAcademicYear(@PathVariable int academicyear) {
        Optional<List<StudentDirectory>> studentDirectories = studentDirectoryService.findByAcademicYear(academicyear);
        return studentDirectories.map(directories ->
                ResponseEntity.ok(StudentDirectoryMapper.toStudentDirectoryDTOList(directories))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/text/{text}")
    public ResponseEntity<List<StudentDirectoryDTO>> searchByText(@PathVariable String text) {
        Optional<List<StudentDirectory>> studentDirectories = studentDirectoryService.findByText(text);
        return studentDirectories.map(directories ->
                ResponseEntity.ok(StudentDirectoryMapper.toStudentDirectoryDTOList(directories))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
