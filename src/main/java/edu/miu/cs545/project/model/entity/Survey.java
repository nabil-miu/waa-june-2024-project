package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Survey extends BasicEntity {

    @NotBlank(message = "Title can't be left empty")
    private String title;

    @Lob
    private String description;

    private LocalDate createdAt;

    private LocalDate expiredAt;

    private boolean isActive;

    @OneToMany(mappedBy = "survey")
    @Valid
    private List<SurveyQuestion> surveyQuestions;

    @OneToMany
    @JoinColumn(name = "survey_responses")
    @Valid
    private List<SurveyResponse> surveyResponses;

}
