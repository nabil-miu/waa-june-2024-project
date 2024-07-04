package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.QuestionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class SurveyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String question;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
    @OneToMany(mappedBy = "question")
    private List<SurveyAnswerChoice> answers;
    @OneToMany(mappedBy = "question")
    private List<SurveyResponse> responses;
}
