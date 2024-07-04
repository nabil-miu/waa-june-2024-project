package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface StudentDirectoryService extends CrudService<StudentDirectory, Long> {
    List<StudentDirectory> findByAcademicYearAndMajorAndOtherFilters(LocalDate academicYear, String major, String otherFilter);
    Page<StudentDirectory> getStudentDirectoryByPage(int pageNumber, int pageSize);
}
