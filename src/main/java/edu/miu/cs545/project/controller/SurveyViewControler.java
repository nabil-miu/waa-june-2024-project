package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.SurveyView;

import edu.miu.cs545.project.service.SurveyViewServce;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/surveyviews")
@Tag(name = "Survey View", description = "Survey View API")
public class SurveyViewControler extends CrudController<SurveyView, Long>{

    public SurveyViewControler(SurveyViewServce crudService) {
        super(crudService);
    }
}
