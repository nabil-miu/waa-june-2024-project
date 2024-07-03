package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDirectoryRepo extends ListCrudRepository<StudentDirectory, Long>, PagingAndSortingRepository<StudentDirectory,Long> {

}


