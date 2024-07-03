package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    @Lob
    private String description;

    private String location;

    private LocalDateTime localDateTime;

    @ManyToMany(mappedBy = "events")
    @Valid
    private List<Student> students;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @Valid
    private List<Rsvp> rsvpList;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @Valid
    private List<Attendance> attendances;
}
