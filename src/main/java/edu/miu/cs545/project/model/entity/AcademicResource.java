package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Data
public class AcademicResource {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    @Lob
    private String description;

    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Valid
    private Student student;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Valid
    private ResourceCategory resourceCategory;
}
