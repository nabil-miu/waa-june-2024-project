package edu.miu.cs545.project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


    @JsonBackReference
    @ManyToMany
    @Valid
    private List<Interest> interests;

    @JsonBackReference
    @ManyToMany
    @Valid
    private List<Event> events;

    @JsonBackReference
    @ManyToMany
    @Valid
    private List<ExtracurricularActivity> activities;

    @JsonBackReference
    @OneToMany(mappedBy = "student")
    @Valid
    private List<SurveyResponse> responses;

    @JsonBackReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private StudentDirectory studentDirectory;

    @JsonBackReference
    @OneToOne
    @Valid
    private Profile profile;

    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<AcademicResource> academicResources;

    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<Rsvp> rsvpList;

    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<Attendance> attendances;

}
