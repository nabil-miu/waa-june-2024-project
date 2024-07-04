package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class StudentDirectory extends BasicEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private Student student;
    private String contactInformation;
    private LocalDate academicYear;
    private String major;

}
