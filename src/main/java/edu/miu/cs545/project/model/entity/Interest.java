package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Interest extends BasicEntity {

    @NotBlank(message = "Interest name can't be left empty")
    private String name;
    @ManyToMany(mappedBy = "interests")
    private List<Student> students;
    @Lob
    private String description;

}
