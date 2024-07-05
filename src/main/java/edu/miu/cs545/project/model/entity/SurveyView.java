package edu.miu.cs545.project.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class SurveyView extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title;

    @Lob
    private String description;
    private boolean isActive;

    @OneToMany(mappedBy = "surveyView", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "question")
    private Map<String, SurveyQuestionView> questionViews = new HashMap<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SurveyId: ").append(id).append("\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Active: ").append(isActive).append("\n");
        for (SurveyQuestionView questionView : questionViews.values()) {
            sb.append(questionView.toString()).append("\n");
        }
        return sb.toString();
    }
}
