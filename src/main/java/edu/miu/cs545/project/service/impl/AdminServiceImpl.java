package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.repository.UserRepo;
import edu.miu.cs545.project.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends CrudServiceImpl<User, Long> implements AdminService {
    private final UserRepo repository;

    public AdminServiceImpl(UserRepo repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void deactivateUser(Long id) {
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setActive(false);
            repository.save(user);
        }
    }
}
