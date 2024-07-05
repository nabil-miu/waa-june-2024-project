package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)

public class SurveyAnswerChoice extends BasicEntity {

    private Character choice;
    private String description;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private SurveyQuestion question;
}
