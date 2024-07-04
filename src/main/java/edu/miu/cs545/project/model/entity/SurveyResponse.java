package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyResponse extends BasicEntity {

    @NotBlank(message = "Answer can't be blank")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

}
