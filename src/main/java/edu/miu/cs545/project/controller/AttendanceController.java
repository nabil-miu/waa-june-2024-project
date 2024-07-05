package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Attendance;
import edu.miu.cs545.project.service.AttendanceService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendances")
@Tag(name = "Attendances", description = "Attendance API")
public class AttendanceController extends CrudController<Attendance, Long> {

    public AttendanceController(AttendanceService service, MeterRegistry registry) {
        super(service, registry);
    }
}
