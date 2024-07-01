package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.service.UserService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Users API")
public class UserController extends CrudController<User, Long> {

    public UserController(UserService userService, MeterRegistry registry) {
        super(userService, registry);
    }
}
