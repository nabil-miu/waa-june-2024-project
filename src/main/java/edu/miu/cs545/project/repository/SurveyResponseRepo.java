package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.SurveyResponse;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResponseRepo extends ListCrudRepository<SurveyResponse,Long> {
}
