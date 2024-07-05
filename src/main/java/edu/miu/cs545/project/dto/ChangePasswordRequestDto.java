package edu.miu.cs545.project.dto;

import lombok.Data;

@Data
public class ChangePasswordRequestDto {
    private String userId;
    private String oldPassword;
    private String newPassword;
}
