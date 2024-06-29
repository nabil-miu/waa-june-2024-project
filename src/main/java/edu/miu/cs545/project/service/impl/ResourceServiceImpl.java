package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Resource;
import edu.miu.cs545.project.repository.ResourceRepo;
import edu.miu.cs545.project.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl extends CrudServiceImpl<Resource, Long> implements ResourceService {

    public ResourceServiceImpl(ResourceRepo repository) {
        super(repository);
    }
}
