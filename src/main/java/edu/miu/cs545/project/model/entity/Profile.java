package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Profile extends BasicEntity {

    @OneToOne(mappedBy = "profile")
    private Student student;
    private String academicAchievements;
    @Lob
    private String personalBio;

}
