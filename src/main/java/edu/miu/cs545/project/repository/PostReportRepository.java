package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Report;
import org.springframework.data.repository.ListCrudRepository;

public interface PostReportRepository extends ListCrudRepository<Report, Long> {
}
