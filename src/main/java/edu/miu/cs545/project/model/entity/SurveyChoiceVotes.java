package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyChoiceVotes extends BasicEntity {

    private String choiceDescription;
    private int voteCount;

    @ManyToOne
    @JoinColumn(name = "question_view_id")
    private SurveyQuestionView questionView;
}
