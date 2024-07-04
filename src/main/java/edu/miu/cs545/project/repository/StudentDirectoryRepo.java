package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDirectoryRepo extends JpaRepository<StudentDirectory,Long> {
}
