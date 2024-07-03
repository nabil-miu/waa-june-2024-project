package edu.miu.cs545.project.mapper.impl;

import edu.miu.cs545.project.dto.StudentDTO;
import edu.miu.cs545.project.model.entity.Student;

import java.time.LocalDate;

public class StudentDtoMapper {
    public static StudentDTO toUserDTO(Student student) {
        if (student == null) {
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setPhone(student.getPhone());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setCity(student.getCity());
        studentDTO.setState(student.getState());
        studentDTO.setZip(student.getZip());
        studentDTO.setCountry(student.getCountry());
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setMajor(student.getMajor());
        studentDTO.setAcademicYear(student.getAcademicYear().getYear());
        return studentDTO;
    }

    public static Student toStudent(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }
        Student student = new Student();
        student.setEmail(studentDTO.getEmail());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPhone(studentDTO.getPhone());
        student.setAddress(studentDTO.getAddress());
        student.setCity(studentDTO.getCity());
        student.setState(studentDTO.getState());
        student.setZip(studentDTO.getZip());
        student.setCountry(studentDTO.getCountry());
        student.setStudentId(studentDTO.getStudentId());
        student.setMajor(studentDTO.getMajor());
        student.setAcademicYear(LocalDate.of(studentDTO.getAcademicYear(), 1, 1));
        student.setDepartment(studentDTO.getDepartment());
        return student;
    }
}
