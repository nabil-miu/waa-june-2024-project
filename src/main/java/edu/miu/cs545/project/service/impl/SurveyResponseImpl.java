package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.SurveyResponse;
import edu.miu.cs545.project.repository.SurveyResponseRepo;
import edu.miu.cs545.project.service.SurveyResponseService;
import org.springframework.stereotype.Service;

@Service
public class SurveyResponseImpl extends CrudServiceImpl<SurveyResponse,Long> implements SurveyResponseService {

    public SurveyResponseImpl(SurveyResponseRepo repository) {
        super(repository);
    }

}
