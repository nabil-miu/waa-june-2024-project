package edu.miu.cs545.project.model.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyResponse extends BasicEntity {

    @Nullable
    private String answer;

    private Character response;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @Valid
    private SurveyQuestion question;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Valid
    private Student student;

}
