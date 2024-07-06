package edu.miu.cs545.project.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyView extends BasicEntity {

    private String title;

    @Lob
    private String description;
    private boolean isActive;

    @OneToMany(mappedBy = "surveyView", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "question")
    private Map<String, SurveyQuestionView> questionViews = new HashMap<>();
    @OneToMany
    private List<SurveyChoiceVotes> answerVotes = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
       // sb.append("SurveyId: ").append(id).append("\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Active: ").append(isActive).append("\n");
        for (SurveyQuestionView questionView : questionViews.values()) {
            sb.append(questionView.toString()).append("\n");
        }
        return sb.toString();
    }
}
