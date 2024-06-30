package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;


//Response ID
//Question ID (FK)
//User ID (FK)
//Answer

@Entity
@Data
public class SurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String answer;
    @OneToOne
    private SurveyQuestion surveyQuestion;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

}
