package edu.miu.cs545.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User extends BasicEntity {

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @Email(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Firstname is mandatory")
    private String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phone;
    private String address;
    private String city;
    private String state;

    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code is invalid")
    private String zip;
    private String country;

    @NotBlank(message = "Role is mandatory")
    private String role;

    private boolean active;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

}
