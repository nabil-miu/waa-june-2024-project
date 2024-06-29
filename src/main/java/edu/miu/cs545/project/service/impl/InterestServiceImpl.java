package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Interest;
import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.repository.InterestRepo;
import edu.miu.cs545.project.repository.UserRepo;
import edu.miu.cs545.project.service.InterestService;
import edu.miu.cs545.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class InterestServiceImpl extends CrudServiceImpl<Interest, Long> implements InterestService {

    public InterestServiceImpl(InterestRepo repository) {
        super(repository);
    }
}
