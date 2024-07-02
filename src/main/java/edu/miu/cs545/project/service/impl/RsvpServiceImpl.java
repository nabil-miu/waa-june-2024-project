package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Event;
import edu.miu.cs545.project.model.entity.Rsvp;
import edu.miu.cs545.project.repository.RsvpRepo;
import edu.miu.cs545.project.service.EventService;
import edu.miu.cs545.project.service.RsvpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RsvpServiceImpl extends CrudServiceImpl<Rsvp, Long> implements RsvpService {

    private final RsvpRepo repository;
    private final EventService eventService;

    public RsvpServiceImpl(RsvpRepo repository, EventService eventService) {
        super(repository);
        this.repository = repository;
        this.eventService = eventService;
    }

    @Override
    public List<Rsvp> getAllRsvpsByEvent(Long eventId) {
        Event event = eventService.getById(eventId).orElseThrow();
        return repository.getRsvpsByEvent(event);
    }
}
