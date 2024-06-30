package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.SurveyQuestion;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyQuestionRepo extends ListCrudRepository<SurveyQuestion,Long> {
}
