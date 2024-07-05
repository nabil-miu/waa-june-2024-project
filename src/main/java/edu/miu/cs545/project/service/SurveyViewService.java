package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.Survey;
import edu.miu.cs545.project.model.entity.SurveyView;

public interface SurveyViewService extends CrudService<SurveyView, Long>{
    SurveyView createSurveyView(Survey survey);
}
