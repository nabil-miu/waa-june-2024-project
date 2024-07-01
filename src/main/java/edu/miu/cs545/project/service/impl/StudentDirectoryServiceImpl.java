package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.repository.StudentDirectoryRepo;
import edu.miu.cs545.project.service.StudentDirectoryService;
import org.springframework.stereotype.Service;

@Service
public class StudentDirectoryServiceImpl extends CrudServiceImpl<StudentDirectory, Long> implements StudentDirectoryService {
    public StudentDirectoryServiceImpl(StudentDirectoryRepo repository) {
        super(repository);
    }
}
