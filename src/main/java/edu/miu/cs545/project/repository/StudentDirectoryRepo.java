package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDirectoryRepo extends GenericRepo<StudentDirectory, Long> {
}
