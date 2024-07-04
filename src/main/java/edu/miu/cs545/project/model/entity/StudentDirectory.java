package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class StudentDirectory extends BasicEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    @Valid
    private Student student;

    @Lob
    @NotBlank(message = "Contact Information can't be left empty")
    private String contactInformation;

    @NotNull
    private LocalDate academicYear;

    @NotBlank(message = "Major required")
    private String major;

}
