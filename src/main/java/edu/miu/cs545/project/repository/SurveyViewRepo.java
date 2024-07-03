package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.SurveyQuestion;
import edu.miu.cs545.project.model.entity.SurveyView;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SurveyViewRepo extends ListCrudRepository<SurveyView,Long>{
}

