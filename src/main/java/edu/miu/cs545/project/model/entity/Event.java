package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    private String description;

    private String location;

    private LocalDateTime localDateTime;

    @ManyToMany(mappedBy = "events")
    private List<User> users;
}
