package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Survey;
import edu.miu.cs545.project.service.SurveyService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/surveys")
@Tag(name = "Surveys", description = "Surveys API")
public class SurveyController extends CrudController<Survey, Long> {

    public SurveyController(SurveyService surveyService, MeterRegistry registry) {
        super(surveyService, registry);
    }
}
