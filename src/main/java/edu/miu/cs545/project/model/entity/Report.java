package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "report_type")
public class Report extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "reported_by_user_id", nullable = false)
    @Valid
    private User reportedBy;

    @Column(nullable = false)
    @NotBlank(message = "Reason can't be left empty")
    private String reason;

    @Column(nullable = false)
    private LocalDate reportDate = LocalDate.now();

}
