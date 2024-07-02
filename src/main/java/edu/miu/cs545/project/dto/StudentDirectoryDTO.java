package edu.miu.cs545.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDirectoryDTO {
    private Long id;
    private UserDTO user;
    private String contactInformation;
    private int academicYear;
    private String major;
}
