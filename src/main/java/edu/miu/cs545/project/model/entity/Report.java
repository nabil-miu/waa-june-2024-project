package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "report_type")
public class Report extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "reported_by_user_id", nullable = false)
    private User reportedBy;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDate reportDate = LocalDate.now();

}
