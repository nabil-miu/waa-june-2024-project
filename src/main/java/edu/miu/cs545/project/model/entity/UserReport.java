package edu.miu.cs545.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("user_report")
public class UserReport extends Report {
    @ManyToOne
    @JoinColumn(name = "target_user_id", nullable = false)
    public User targetUser;
}
