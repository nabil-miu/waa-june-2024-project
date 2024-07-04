package edu.miu.cs545.project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UserBlock extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "blocker_id", nullable = false)
    @Valid
    private User blocker;

    @ManyToOne
    @JoinColumn(name = "blocked_id", nullable = false)
    @Valid
    private User blocked;

    @Column(nullable = false)
    private LocalDate blockDate = LocalDate.now();

}
