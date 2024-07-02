package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ThreadPost {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private  String title;

    @Column( updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    private ResourceCategory resourceCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    private  User user;


    // Callback methods for title and createdAt
    @PrePersist
    private void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.title != null) {
            this.title = this.title.trim().toLowerCase();
        }

    }

    @PreUpdate
    private void preUpdate() {
        if (this.title != null) {
            this.title = this.title.trim().toLowerCase();
        }
    }
}
