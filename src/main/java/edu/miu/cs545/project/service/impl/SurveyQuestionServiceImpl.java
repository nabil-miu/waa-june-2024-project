package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.repository.SurveyQuestionRepo;
import edu.miu.cs545.project.service.SurveyQuestionService;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SurveyQuestionServiceImpl extends CrudServiceImpl implements SurveyQuestionService {
    public SurveyQuestionServiceImpl(SurveyQuestionRepo repository) {
        super(repository);
    }
}
