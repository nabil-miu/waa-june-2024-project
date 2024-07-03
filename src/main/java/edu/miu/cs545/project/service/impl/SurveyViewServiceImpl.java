package edu.miu.cs545.project.service.impl;


import edu.miu.cs545.project.model.entity.SurveyQuestion;
import edu.miu.cs545.project.model.entity.SurveyView;
import edu.miu.cs545.project.repository.SurveyViewRepo;
import edu.miu.cs545.project.service.SurveyViewServce;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SurveyViewServiceImpl extends CrudServiceImpl<SurveyView,Long> implements SurveyViewServce {
    public SurveyViewServiceImpl(SurveyViewRepo repository) {
        super(repository);
    }
}



