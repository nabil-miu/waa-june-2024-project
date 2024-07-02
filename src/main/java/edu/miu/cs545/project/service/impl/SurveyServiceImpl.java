package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Survey;
import edu.miu.cs545.project.repository.SurveyRepo;
import edu.miu.cs545.project.service.SurveyService;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl extends CrudServiceImpl<Survey,Long> implements SurveyService {
    public SurveyServiceImpl(SurveyRepo repository) {
        super(repository);
    }
}
