package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.ExtracurricularActivity;
import edu.miu.cs545.project.service.ExtracurricularActivityService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/extracurricular-activity")
@Tag(name = "Extracurricular Activity", description = "Extracurricular Activity API")
public class ExtracurricularActivityController extends CrudController<ExtracurricularActivity, Long> {

    public ExtracurricularActivityController(ExtracurricularActivityService service, MeterRegistry registry) {
        super(service, registry);
    }

}
