package edu.miu.cs545.project.model.entity;

import edu.miu.cs545.project.model.UserType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String role;
    private String studentId;
    private String major;
    private LocalDate academicYear;
    private String department;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @ManyToMany
    private List<Event> events;
}
