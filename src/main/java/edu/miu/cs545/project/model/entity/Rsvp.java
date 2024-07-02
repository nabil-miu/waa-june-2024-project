package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.StatusType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
public class Rsvp {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
