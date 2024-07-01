package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
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
