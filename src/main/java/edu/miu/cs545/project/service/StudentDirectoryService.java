package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.repository.StudentDirectoryRepo;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentDirectoryService extends CrudService<StudentDirectory, Long> {

    List<StudentDirectory> findByAcademicYearAndMajorAndOtherFilters(LocalDate academicYear, String major, String otherFilter);
    Page<StudentDirectory> getStudentDirectoryByPage(int pageNumber, int pageSize);
}
