package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Rsvp;
import edu.miu.cs545.project.service.RsvpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rsvp")
@Tag(name = "RSVP", description = "RSVP API")
public class RsvpController extends CrudController<Rsvp, Long> {

    public RsvpController(RsvpService service) {
        super(service);
    }

}
