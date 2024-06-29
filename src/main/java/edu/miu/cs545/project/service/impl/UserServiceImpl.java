package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.repository.UserRepo;
import edu.miu.cs545.project.service.util.CrudServiceImpl;
import edu.miu.cs545.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {

    public UserServiceImpl(UserRepo repository) {
        super(repository);
    }
}
