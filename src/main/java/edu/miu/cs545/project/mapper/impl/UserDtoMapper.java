package edu.miu.cs545.project.mapper.impl;

import edu.miu.cs545.project.dto.UserDTO;
import edu.miu.cs545.project.model.entity.User;

import java.time.LocalDate;

public class UserDtoMapper{
    public static UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());
        userDTO.setState(user.getState());
        userDTO.setZip(user.getZip());
        userDTO.setCountry(user.getCountry());
        userDTO.setStudentId(user.getStudentId());
        userDTO.setMajor(user.getMajor());
        userDTO.setAcademicYear(user.getAcademicYear().getYear());
        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setZip(userDTO.getZip());
        user.setCountry(userDTO.getCountry());
        user.setStudentId(userDTO.getStudentId());
        user.setMajor(userDTO.getMajor());
        user.setAcademicYear(LocalDate.of(userDTO.getAcademicYear(), 1, 1));
        return user;
    }
}
