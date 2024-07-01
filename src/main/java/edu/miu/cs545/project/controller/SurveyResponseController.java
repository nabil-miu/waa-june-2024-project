package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.SurveyResponse;
import edu.miu.cs545.project.service.CrudService;
import edu.miu.cs545.project.service.SurveyResponseService;
import edu.miu.cs545.project.service.impl.SurveyResponseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/survey-responses")
@Tag(name = "Survey Responses", description = "Survey Response API")
public class SurveyResponseController extends CrudController<SurveyResponse,Long>{


    public SurveyResponseController(SurveyResponseService crudService) {
        super(crudService);
    }
}
