package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Users API")
public class UserController extends CrudController<User, Long> {

    private final UserService userService;
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    public ResponseEntity<Page<User>> getUserByPage(@RequestParam int pageSize){
        Page<User> userPage = userService.getUsersByPage(pageSize);
        return null;
    }
}
