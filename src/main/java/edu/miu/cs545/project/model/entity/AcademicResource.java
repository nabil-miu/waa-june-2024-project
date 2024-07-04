package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AcademicResource extends BasicEntity{

    @NotBlank(message = "Resource name can't be left empty")
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
