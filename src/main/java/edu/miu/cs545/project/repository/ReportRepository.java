package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Report;
import edu.miu.cs545.project.model.entity.User;

import java.util.List;

public interface ReportRepository extends GenericRepo<Report, Long> {
    List<Report> findAllByReportedByIs(User user);
}
