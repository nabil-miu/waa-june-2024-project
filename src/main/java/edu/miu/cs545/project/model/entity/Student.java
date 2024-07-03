package edu.miu.cs545.project.model.entity;

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
    @ManyToMany
    private List<Interest> interests;

    @ManyToMany
    private List<Event> events;

    @ManyToMany
    private List<ExtracurricularActivity> activities;

    @OneToMany(mappedBy = "student")
    private List<SurveyResponse> responses;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDirectory studentDirectory;

    @OneToOne
    private Profile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<AcademicResource> academicResources;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Rsvp> rsvpList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendances;
}
