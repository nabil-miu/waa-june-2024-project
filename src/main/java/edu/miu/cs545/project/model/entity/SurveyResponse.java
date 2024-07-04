package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Data
public class SurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private Character response;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private SurveyQuestion question;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

}
