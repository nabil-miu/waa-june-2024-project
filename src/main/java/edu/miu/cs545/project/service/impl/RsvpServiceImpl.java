package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Rsvp;
import edu.miu.cs545.project.repository.RsvpRepo;
import edu.miu.cs545.project.service.RsvpService;
import org.springframework.stereotype.Service;

@Service
public class RsvpServiceImpl extends CrudServiceImpl<Rsvp, Long> implements RsvpService {

    public RsvpServiceImpl(RsvpRepo repository) {
        super(repository);
    }

}
