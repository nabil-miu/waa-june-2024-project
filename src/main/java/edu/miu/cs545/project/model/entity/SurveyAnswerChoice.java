package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Data
public class SurveyAnswerChoice extends BasicEntity{

    private Character choice;
    private String description;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private SurveyQuestion question;
}
