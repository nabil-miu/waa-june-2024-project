package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Profile;
import edu.miu.cs545.project.service.ProfileService;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends CrudServiceImpl<Profile, Long> implements ProfileService {
    public ProfileServiceImpl(ListCrudRepository<Profile, Long> repository) {
        super(repository);
    }
}
