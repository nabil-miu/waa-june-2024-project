package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.AttendanceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Attendance extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private AttendanceType status;
    private LocalDate attendanceDate;

}
