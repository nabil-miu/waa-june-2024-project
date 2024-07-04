package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.StatusType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Rsvp extends BasicEntity {

    @NotNull
    @FutureOrPresent(message = "The date must be in the present or future")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Valid
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @Valid
    private Event event;

}
