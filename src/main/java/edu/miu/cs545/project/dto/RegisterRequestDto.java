package edu.miu.cs545.project.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;
    private String password;
}
