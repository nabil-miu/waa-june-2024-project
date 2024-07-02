package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
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
    private List<User> users;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Rsvp> rsvpList;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Attendance> attendances;
}
