package edu.miu.cs545.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("post_report")
public class PostReport extends Report {
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    public Post post;
}
