package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SurveyChoiceVotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String choiceDescription;
    private int voteCount;

    @ManyToOne
    @JoinColumn(name = "question_view_id")
    private SurveyQuestionView questionView;
}
