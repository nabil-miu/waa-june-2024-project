package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
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
    @JoinColumn
    private User user;
}