package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.Survey;

import java.util.List;

public interface SurveyService extends CrudService<Survey, Long>{
    List<Survey> getAllActiveSurveys();
}
