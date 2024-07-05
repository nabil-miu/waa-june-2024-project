package edu.miu.cs545.project.controller;

import com.auth0.json.mgmt.users.User;
import edu.miu.cs545.project.aop.LogExecutionTime;
import edu.miu.cs545.project.dto.ChangePasswordRequestDto;
import edu.miu.cs545.project.dto.LoginRequestDto;
import edu.miu.cs545.project.dto.LoginResponseDto;
import edu.miu.cs545.project.dto.RegisterRequestDto;
import edu.miu.cs545.project.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Tag(name = "Authentication", description = "Authentication API")
public class AuthController {
    private final AuthService authService;

    @LogExecutionTime
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        try {
            String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
            LoginResponseDto loginResponse = new LoginResponseDto();
            loginResponse.setToken(token);
            return ResponseEntity.ok().body(loginResponse);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @LogExecutionTime
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequest) {
        try {
            authService.changePassword(changePasswordRequest.getEmail(), changePasswordRequest.getNewPassword());
            return ResponseEntity.ok().body("Password changed successfully");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @LogExecutionTime
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequest) {
        try {
            User user = authService.register(registerRequest.getEmail(), registerRequest.getPassword());
            return ResponseEntity.ok().body(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
