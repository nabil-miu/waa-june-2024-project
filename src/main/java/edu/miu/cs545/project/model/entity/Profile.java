package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Profile extends BasicEntity {

    @OneToOne(mappedBy = "profile")
    @Valid
    private Student student;
    private String academicAchievements;
    @Lob
    private String personalBio;

}
