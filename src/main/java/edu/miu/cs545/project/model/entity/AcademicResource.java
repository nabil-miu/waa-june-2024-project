package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AcademicResource {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    private String description;

    private String url;

    @ManyToOne
    @JoinColumn
    private User user;
}
