package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.Rsvp;

import java.util.List;

public interface RsvpService extends CrudService<Rsvp, Long> {

    List<Rsvp> getAllRsvpsByEvent(Long eventId);

}
