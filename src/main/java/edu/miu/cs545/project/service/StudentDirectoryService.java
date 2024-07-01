package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.StudentDirectory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentDirectoryService extends CrudService<StudentDirectory, Long> {
    Optional<List<StudentDirectory>> findByMajor(String major);
    Optional<List<StudentDirectory>> findByAcademicYear(LocalDate date);
}
