package edu.miu.cs545.project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity
public class ResourceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Category name can't be left empty")
    private String name;

    @Lob
    @Nullable
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parent_id")
    @Nullable
    private ResourceCategory parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Nullable
    private List<ResourceCategory> categoryList;
}
