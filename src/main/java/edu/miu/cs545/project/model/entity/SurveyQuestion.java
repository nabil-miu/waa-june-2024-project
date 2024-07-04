package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyQuestion extends BasicEntity {

    @Lob
    private String question;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    @Valid
    private Survey survey;

    @OneToMany(mappedBy = "question")
    @Valid
    private List<SurveyAnswerChoice> answers;

    @OneToMany(mappedBy = "question")
    @Valid
    private List<SurveyResponse> responses;

}
