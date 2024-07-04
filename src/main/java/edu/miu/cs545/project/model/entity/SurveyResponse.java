package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyResponse extends BasicEntity {

    private String answer;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

}
