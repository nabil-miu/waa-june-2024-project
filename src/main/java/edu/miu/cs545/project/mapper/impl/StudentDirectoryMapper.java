package edu.miu.cs545.project.mapper.impl;

import edu.miu.cs545.project.dto.StudentDirectoryDTO;
import edu.miu.cs545.project.model.entity.StudentDirectory;

import java.util.ArrayList;
import java.util.List;

public class StudentDirectoryMapper {
    public static StudentDirectoryDTO toStudentDirectoryDTO(StudentDirectory studentDirectory) {
        if (studentDirectory == null) {
            return null;
        }
        StudentDirectoryDTO studentDirectoryDTO = new StudentDirectoryDTO();
        studentDirectoryDTO.setId(studentDirectory.getId());
        studentDirectoryDTO.setStudentDTO(StudentDtoMapper.toUserDTO(studentDirectory.getStudent()));
        studentDirectoryDTO.setContactInformation(studentDirectory.getContactInformation());
        studentDirectoryDTO.setAcademicYear(studentDirectory.getAcademicYear());
        studentDirectoryDTO.setMajor(studentDirectory.getMajor());
        return studentDirectoryDTO;
    }

    public static StudentDirectory toStudentDirectory(StudentDirectoryDTO studentDirectoryDTO) {
        if (studentDirectoryDTO == null) {
            return null;
        }
        StudentDirectory studentDirectory = new StudentDirectory();
        studentDirectory.setStudent(StudentDtoMapper.toStudent(studentDirectoryDTO.getStudentDTO()));
        studentDirectory.setContactInformation(studentDirectoryDTO.getContactInformation());
        studentDirectory.setAcademicYear(studentDirectoryDTO.getAcademicYear());
        studentDirectory.setMajor(studentDirectoryDTO.getMajor());
        return studentDirectory;
    }

    public static List<StudentDirectoryDTO> toStudentDirectoryDTOList(List<StudentDirectory> studentDirectories) {
        List<StudentDirectoryDTO> studentDirectoryDTOs = new ArrayList<>();
        if (studentDirectories != null) {
            for (StudentDirectory studentDirectory : studentDirectories) {
                studentDirectoryDTOs.add(toStudentDirectoryDTO(studentDirectory));
            }
        }
        return studentDirectoryDTOs;
    }
}
