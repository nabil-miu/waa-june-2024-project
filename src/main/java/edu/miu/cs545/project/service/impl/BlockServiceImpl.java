package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.model.entity.UserBlock;
import edu.miu.cs545.project.repository.UserBlockRepository;
import edu.miu.cs545.project.service.BlockService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlockServiceImpl extends CrudServiceImpl<UserBlock, Long> implements BlockService {
    private final UserBlockRepository repository;

    public BlockServiceImpl(UserBlockRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserBlock blockUser(User blocker, User blocked) {
        if (isUserBlocked(blocker, blocked)) {
            throw new IllegalStateException("User already blocked");
        }

        UserBlock userBlock = new UserBlock();
        userBlock.setBlocker(blocker);
        userBlock.setBlocked(blocked);
        userBlock.setBlockDate(LocalDate.now());
        return repository.save(userBlock);
    }

    @Override
    public UserBlock unblockUser(User blocker, User blocked) {
        UserBlock userBlock = repository.findByBlockerAndBlocked(blocker, blocked);
        if (userBlock == null) {
            throw new IllegalStateException("User not blocked");
        }

        repository.delete(userBlock);
        return userBlock;
    }

    @Override
    public Boolean isUserBlocked(User blocker, User blocked) {
        return repository.existsByBlockerAndBlocked(blocker, blocked);
    }

    @Override
    public List<User> getBlockedUsers(User blocker) {
        return repository.findUserBlockByBlockerIs(blocker).stream().map(UserBlock::getBlocked).toList();
    }
}
