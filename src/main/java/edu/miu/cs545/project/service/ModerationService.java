package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.*;

public interface ModerationService extends CrudService<Report, Long> {
    UserReport reportUser(User reporter, User targetUser, String reason);

    PostReport reportPost(User reporter, Post post, String reason);
}
