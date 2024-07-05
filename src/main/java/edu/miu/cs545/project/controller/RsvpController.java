package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Rsvp;
import edu.miu.cs545.project.service.RsvpService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rsvp")
@Tag(name = "RSVP", description = "RSVP API")
public class RsvpController extends CrudController<Rsvp, Long> {

    private final RsvpService service;

    public RsvpController(RsvpService service, MeterRegistry registry) {
        super(service, registry);
        this.service = service;
    }

    @GetMapping("/event")
    public ResponseEntity<List<Rsvp>> getAllRsvpsByEvent(@RequestParam Long eventId) {
        List<Rsvp> rsvpList = service.getAllRsvpsByEvent(eventId);
        return ResponseEntity.ok(rsvpList);
    }
}
