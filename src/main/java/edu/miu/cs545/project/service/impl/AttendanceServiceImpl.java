package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Attendance;
import edu.miu.cs545.project.repository.AttendanceRepo;
import edu.miu.cs545.project.service.AttendanceService;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl extends CrudServiceImpl<Attendance, Long> implements AttendanceService {

    public AttendanceServiceImpl(AttendanceRepo repository) {
        super(repository);
    }
}
