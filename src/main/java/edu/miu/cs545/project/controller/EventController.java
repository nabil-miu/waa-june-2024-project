package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Event;
import edu.miu.cs545.project.service.EventService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Events", description = "Events API")
public class EventController extends CrudController<Event, Long> {


    public EventController(EventService service, MeterRegistry registry) {
        super(service, registry);
    }
}
