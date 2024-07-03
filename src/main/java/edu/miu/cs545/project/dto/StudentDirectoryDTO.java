package edu.miu.cs545.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDirectoryDTO {
    private Long id;
    private StudentDTO studentDTO;
    private String contactInformation;
    private LocalDate academicYear;
    private String major;
}
