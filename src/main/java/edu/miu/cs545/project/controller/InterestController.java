package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Interest;
import edu.miu.cs545.project.service.InterestService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interests")
@Tag(name = "Interests", description = "Interests API")
public class InterestController extends CrudController<Interest, Long> {

    public InterestController(InterestService service, MeterRegistry registry) {
        super(service, registry);
    }

}
