package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.StatusType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Rsvp extends BasicEntity {

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
