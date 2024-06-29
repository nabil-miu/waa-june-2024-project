package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.model.entity.Resource;
import edu.miu.cs545.project.service.impl.ResourceServiceImpl;

public class ResourceController extends CrudController<Resource, Long> {

    public ResourceController(ResourceServiceImpl service) {
        super(service);
    }
}
