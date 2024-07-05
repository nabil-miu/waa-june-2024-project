package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class SurveyQuestionView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private int totalVotes;

    @ManyToOne
    @JoinColumn(name = "survey_view_id")
    private SurveyView surveyView;

    @OneToMany(mappedBy = "questionView", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyChoiceVotes> choiceVotes = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(question).append(" {\n");
        for (SurveyChoiceVotes cv : choiceVotes) {
            sb.append("     Choice ").append(cv.getChoiceDescription()).append(": ").append(cv.getVoteCount()).append(" votes\n");
        }
        sb.append("     Total: ").append(totalVotes).append(" total votes\n}");
        return sb.toString();
    }
}
