package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.repository.StudentDirectoryRepo;
import edu.miu.cs545.project.service.StudentDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDirectoryServiceImpl extends CrudServiceImpl<StudentDirectory, Long> implements StudentDirectoryService {

    @Autowired
    private StudentDirectoryRepo studentDirectoryRepo;

    public StudentDirectoryServiceImpl(StudentDirectoryRepo repository) {
        super(repository);
    }

    public Optional<List<StudentDirectory>> findByMajor(String major) {
        return studentDirectoryRepo.findByMajor(major);
    }

    @Override
    public Optional<List<StudentDirectory>> findByAcademicYear(int date) {
        return studentDirectoryRepo.findByAcademicYear(date);
    }

    public Optional<List<StudentDirectory>> findByText(String tx) {
        String text = tx.toLowerCase();
        return studentDirectoryRepo.findByUser_FirstNameOrUser_LastNameOrUser_UsernameOrUserEmailOrUser_PhoneOrUser_AddressOrUser_CityOrUser_StateOrUser_ZipOrUser_CountryOrUser_Department(
                text,text,text,text,text,text,text,text,text,text,text);
    }

    @Override
    public List<StudentDirectory> findAll() {
        return studentDirectoryRepo.findAll();
    }


}
