package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.model.entity.UserBlock;

import java.util.List;

public interface UserBlockRepository extends GenericRepo<UserBlock, Long> {

    boolean existsByBlockerAndBlocked(User blocker, User blocked);

    UserBlock findByBlockerAndBlocked(User blocker, User blocked);

    List<UserBlock> findUserBlockByBlockerIs(User blocker);

}
