package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.HashMap;


@Entity
@Data
public class SurveyAnswerChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private Character choice;
    private String description;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private SurveyQuestion question;
}
