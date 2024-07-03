package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class UserBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blocker_id", nullable = false)
    private User blocker;

    @ManyToOne
    @JoinColumn(name = "blocked_id", nullable = false)
    private User blocked;

    @Column(nullable = false)
    private LocalDate blockDate = LocalDate.now();
}
