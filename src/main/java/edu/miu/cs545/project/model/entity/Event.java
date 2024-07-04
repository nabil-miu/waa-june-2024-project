package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Event extends BasicEntity {

    @NotBlank(message = "Event name can't be left empty")
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
