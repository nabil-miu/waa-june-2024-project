package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Survey extends BasicEntity {

    private String title;
    private String description;
    private LocalDate createdAt;
    private LocalDate expiredAt;
    private boolean isActive;
    @OneToMany(mappedBy = "survey")
    private List<SurveyQuestion> surveyQuestions;
    @OneToMany
    @JoinColumn(name = "survey_responses")
    private List<SurveyResponse> surveyResponses;

}
