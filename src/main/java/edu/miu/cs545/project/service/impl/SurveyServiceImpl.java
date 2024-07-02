package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Survey;
import edu.miu.cs545.project.repository.SurveyRepo;
import edu.miu.cs545.project.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyServiceImpl extends CrudServiceImpl<Survey,Long> implements SurveyService {
    @Autowired
    private SurveyRepo surveyRepo;

    public SurveyServiceImpl(SurveyRepo repository) {
        super(repository);
    }

    public List<Survey> getAllActiveSurveys() {
        LocalDate date = LocalDate.now();
        return surveyRepo.findByExpiredAtAfter(date);
    }
}
