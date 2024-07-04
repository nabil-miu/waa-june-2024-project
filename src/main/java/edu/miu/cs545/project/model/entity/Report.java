package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "report_type")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reported_by_user_id", nullable = false)
    private User reportedBy;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDate reportDate = LocalDate.now();
}
