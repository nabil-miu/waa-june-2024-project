package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.AttendanceType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Attendance extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "event_id")
    @Valid
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Valid
    private Student student;

    @Enumerated(EnumType.STRING)
    private AttendanceType status;

    private LocalDate attendanceDate;

}
