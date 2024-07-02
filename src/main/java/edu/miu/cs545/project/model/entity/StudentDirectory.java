package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class StudentDirectory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Student student;
    private String contactInformation;
    private LocalDate academicYear;
    private String major;
}
