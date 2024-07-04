package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Profile;
import edu.miu.cs545.project.repository.ProfileRepo;
import edu.miu.cs545.project.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends CrudServiceImpl<Profile, Long> implements ProfileService {

    private final ProfileRepo repository;

    public ProfileServiceImpl(ProfileRepo repository) {
        super(repository);
        this.repository = repository;
    }

}
