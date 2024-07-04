package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ThreadPost extends BasicEntity {

    @Column(unique = true, nullable = false)
    private  String title;

    @Column( updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @Valid
    private ResourceCategory resourceCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @Valid
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
