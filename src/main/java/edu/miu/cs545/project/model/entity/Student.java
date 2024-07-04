package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {

    @NotBlank(message = "Student id required")
    private String studentId;

    @NotNull
    private LocalDate academicYear;

    @NotBlank(message = "Department required")
    private String department;

    @NotBlank(message = "Major required")
    private String major;

    @ManyToMany
    @Valid
    private List<Interest> interests;

    @ManyToMany
    @Valid
    private List<Event> events;

    @ManyToMany
    @Valid
    private List<ExtracurricularActivity> activities;

    @OneToMany(mappedBy = "student")
    @Valid
    private List<SurveyResponse> responses;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private StudentDirectory studentDirectory;

    @OneToOne
    @Valid
    private Profile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<AcademicResource> academicResources;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<Rsvp> rsvpList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<Attendance> attendances;

}
