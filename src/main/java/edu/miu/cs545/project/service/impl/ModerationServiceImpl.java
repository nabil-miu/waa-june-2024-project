package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.*;
import edu.miu.cs545.project.repository.PostReportRepository;
import edu.miu.cs545.project.service.ModerationService;
import org.springframework.stereotype.Service;

@Service
public class ModerationServiceImpl extends CrudServiceImpl<Report, Long> implements ModerationService {

    private final PostReportRepository repository;

    public ModerationServiceImpl(PostReportRepository repository) {
        super(repository);
        this.repository = repository;

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
}
