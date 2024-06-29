package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Event;
import edu.miu.cs545.project.repository.EventRepo;
import edu.miu.cs545.project.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends CrudServiceImpl<Event, Long> implements EventService {

    public EventServiceImpl(EventRepo repository) {
        super(repository);
    }
}
