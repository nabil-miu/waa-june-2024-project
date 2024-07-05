package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Profile;
import edu.miu.cs545.project.service.ProfileService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profiles")
@Tag(name = "Profiles", description = "Profiles API")
public class ProfileController extends CrudController<Profile, Long> {

    public ProfileController(ProfileService service, MeterRegistry registry) {
        super(service, registry);
    }
}
