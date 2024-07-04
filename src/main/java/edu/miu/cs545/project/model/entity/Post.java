package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends BasicEntity {

    @Lob
    private String content;

    @ManyToOne
    @Valid
    private ThreadPost threadPost;

    @ManyToOne
    @JoinColumn(name = "parent_post_id")
    @Valid
    private Post parentPost;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Callback methods for updatedAt and createdAt
    @PrePersist
    private void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
