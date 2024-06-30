package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.SurveyQuestion;
import edu.miu.cs545.project.service.CrudService;
import edu.miu.cs545.project.service.impl.SurveyQuestionServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/survey-questions")
@Tag(name = "Survey questions", description = "Survey questions API")
public class SurveyQuestionController extends CrudController<SurveyQuestion,Long>{


    public SurveyQuestionController(SurveyQuestionServiceImpl Service) {
        super(Service);
    }
}
