package edu.miu.cs545.project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ResourceCategory extends BasicEntity {

    @NotBlank(message = "Category name can't be left empty")
    private String name;

    @Lob
    @Nullable
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "parent_id")
    @Nullable
    private ResourceCategory parent;

    @JsonBackReference
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Nullable
    private List<ResourceCategory> categoryList;

}
