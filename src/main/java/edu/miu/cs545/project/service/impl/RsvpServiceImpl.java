package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Event;
import edu.miu.cs545.project.model.entity.Rsvp;
import edu.miu.cs545.project.repository.RsvpRepo;
import edu.miu.cs545.project.service.RsvpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RsvpServiceImpl extends CrudServiceImpl<Rsvp, Long> implements RsvpService {

    private final RsvpRepo repository;

    public RsvpServiceImpl(RsvpRepo repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Rsvp> getAllRsvpsByEvent(Event event) {
        return repository.getRsvpsByEvent(event);
    }
}
