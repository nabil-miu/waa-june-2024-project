package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.SurveyResponse;
import edu.miu.cs545.project.model.entity.SurveyView;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyViewRepo extends GenericRepo<SurveyView, Long>{
}
