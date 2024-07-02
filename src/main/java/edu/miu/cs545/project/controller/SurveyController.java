package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Survey;
import edu.miu.cs545.project.service.SurveyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/surveys")
@Tag(name = "Surveys", description = "Surveys API")
public class SurveyController extends CrudController<Survey, Long> {

    private final SurveyService surveyService;
    public SurveyController(SurveyService surveyService) {
        super(surveyService);
        this.surveyService = surveyService;
    }
    @GetMapping("/active")
    public ResponseEntity<List<Survey>> getActiveSurveys() {
        List<Survey> surveys = surveyService.getAllActiveSurveys();
        return ResponseEntity.ok().body(surveys);
    }


}
