package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.model.entity.UserBlock;

import java.util.List;

public interface BlockService extends CrudService<UserBlock, Long> {
    UserBlock blockUser(User blocker, User blocked);

    UserBlock unblockUser(User blocker, User blocked);

    Boolean isUserBlocked(User blocker, User blocked);

    List<User> getBlockedUsers(User blocker);
}
