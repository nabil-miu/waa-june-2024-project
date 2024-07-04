package edu.miu.cs545.project.dto;

import lombok.Data;

@Data
public class ReportRequestDto {
    private Long reporterId;
    private String reason;
}
