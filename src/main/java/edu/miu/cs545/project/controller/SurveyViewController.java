package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Survey;
import edu.miu.cs545.project.model.entity.SurveyView;
import edu.miu.cs545.project.repository.SurveyRepo;
import edu.miu.cs545.project.repository.SurveyViewRepo;
import edu.miu.cs545.project.service.CrudService;
import edu.miu.cs545.project.service.SurveyViewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/survey-views")
@Tag(name = "Survey View", description = "Survey View API")
public class SurveyViewController extends CrudController<SurveyView, Long> {
    private final SurveyViewService surveyViewService;
    private final SurveyRepo surveyRepo;
    public SurveyViewController(SurveyViewService crudService, SurveyRepo surveyRepo) {
        super(crudService);
        this.surveyViewService = crudService;
        this.surveyRepo = surveyRepo;
    }
    @GetMapping("/findBy/{id}")
    public ResponseEntity<?> createSurveyView(@PathVariable long id) {
        Optional<Survey>  survey = surveyRepo.findById(id);
        if(survey.isPresent()) {
            SurveyView surveyView = surveyViewService.createSurveyView(survey.get());
            return ResponseEntity.ok(surveyView);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
