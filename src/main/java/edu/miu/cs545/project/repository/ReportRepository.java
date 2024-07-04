package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Report;
import edu.miu.cs545.project.model.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReportRepository extends ListCrudRepository<Report, Long> {
    List<Report> findAllByReportedByIs(User user);
}
