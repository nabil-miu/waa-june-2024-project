package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Survey;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SurveyRepo extends ListCrudRepository<Survey, Long> {
    List<Survey> findSurveyByExpiredAtAfter(LocalDate now);
}
