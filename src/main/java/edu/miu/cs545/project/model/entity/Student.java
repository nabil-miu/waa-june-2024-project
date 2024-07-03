package edu.miu.cs545.project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {
    private String studentId;
    private LocalDate academicYear;
    private String department;
    private String major;

    @JsonBackReference
    @ManyToMany
    private List<Interest> interests;

    @JsonBackReference
    @ManyToMany
    private List<Event> events;

    @JsonBackReference
    @ManyToMany
    private List<ExtracurricularActivity> activities;

    @JsonBackReference
    @OneToMany(mappedBy = "student")
    private List<SurveyResponse> responses;

    @JsonBackReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDirectory studentDirectory;

    @JsonBackReference
    @OneToOne
    private Profile profile;

    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<AcademicResource> academicResources;

    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Rsvp> rsvpList;

    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendances;
}
