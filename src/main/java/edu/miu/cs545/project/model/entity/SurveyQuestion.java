package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.QuestionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyQuestion extends BasicEntity {

    @Lob
    private String question;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    @OneToOne
    private SurveyResponse surveyResponse;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

}
