package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.*;
import edu.miu.cs545.project.repository.ReportRepository;
import edu.miu.cs545.project.repository.UserRepo;
import edu.miu.cs545.project.service.ModerationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModerationServiceImpl extends CrudServiceImpl<Report, Long> implements ModerationService {

    private final ReportRepository repository;
    private final UserRepo userRepo;

    public ModerationServiceImpl(ReportRepository repository, UserRepo userRepo) {
        super(repository);
        this.repository = repository;
        this.userRepo = userRepo;
    }

    @Override
    public UserReport reportUser(User reporter, User targetUser, String reason) {
        UserReport report = new UserReport();
        report.setReportedBy(reporter);
        report.setTargetUser(targetUser);
        report.setReason(reason);
        return repository.save(report);
    }

    @Override
    public PostReport reportPost(User reporter, Post post, String reason) {
        PostReport report = new PostReport();
        report.setReportedBy(reporter);
        report.setPost(post);
        report.setReason(reason);
        return repository.save(report);
    }

    @Override
    public List<Report> getReportsByUser(Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        return repository.findAllByReportedByIs(user);
    }
}
