package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.repository.UserRepo;
import edu.miu.cs545.project.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {

    private final UserRepo repository;

    public UserServiceImpl(UserRepo repository) {
        super(repository);
        this.repository = repository;

    }

    public Page<User> getUsersByPage(int pageSize) {
        PageRequest firstPageWithTwoElements = PageRequest.of(0, pageSize);
       Page<User> userByPage = repository.findAll(firstPageWithTwoElements);
       return userByPage;
    }
}
